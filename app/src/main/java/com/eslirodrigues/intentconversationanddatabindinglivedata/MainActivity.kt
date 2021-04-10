package com.eslirodrigues.intentconversationanddatabindinglivedata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import com.eslirodrigues.intentconversationanddatabindinglivedata.countdatabinding.CountActivity
import com.eslirodrigues.intentconversationanddatabindinglivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launchActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val textRequest: String? = data?.getStringExtra("key")
                binding.textViewReceived.text = textRequest
            }
        }

        binding.buttonRequest.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            launchActivity.launch(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuCountActivity -> startActivity(Intent(this, CountActivity::class.java))
        }
        return true
    }
}
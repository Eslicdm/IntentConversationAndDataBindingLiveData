package com.eslirodrigues.intentconversationanddatabindinglivedata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eslirodrigues.intentconversationanddatabindinglivedata.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSendBack.setOnClickListener {
            val textRequest = binding.editTextSendBack.text.toString()
            if (textRequest.isNotEmpty()) {
                val intent = Intent().putExtra("key", textRequest)
                setResult(Activity.RESULT_OK, intent)
            } else {
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }
    }
}
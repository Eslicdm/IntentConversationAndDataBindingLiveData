package com.eslirodrigues.intentconversationanddatabindinglivedata.countdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.eslirodrigues.intentconversationanddatabindinglivedata.R
import com.eslirodrigues.intentconversationanddatabindinglivedata.databinding.ActivityCountBinding

class CountActivity : AppCompatActivity() {

    private val viewModel: CountViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCountBinding = DataBindingUtil.setContentView(this, R.layout.activity_count)

        binding.countViewModel = viewModel
        binding.lifecycleOwner = this
    }
}
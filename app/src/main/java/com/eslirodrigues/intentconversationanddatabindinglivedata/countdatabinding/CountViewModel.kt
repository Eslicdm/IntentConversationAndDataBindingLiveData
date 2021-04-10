package com.eslirodrigues.intentconversationanddatabindinglivedata.countdatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {

    private var number = 0

    private var _count = MutableLiveData<String>()
    val count: LiveData<String> get() = _count

    init {
        _count.value = number.toString()
    }

    fun addCount() {
        _count.value = (++number).toString()
    }
}
package com.ydnm4528.moviedb.ui.toprated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopratedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Toprated Fragment"
    }
    val text: LiveData<String> = _text
}
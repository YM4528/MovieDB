package com.ydnm4528.moviedb.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PopularViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Popular Fragment"
    }
    val text: LiveData<String> = _text
}
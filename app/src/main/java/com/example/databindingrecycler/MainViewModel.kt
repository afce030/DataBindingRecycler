package com.example.databindingrecycler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val items = MutableLiveData<List<MessageItem>>().apply { value = listOf(
            MessageItem("title1","txt1"),
            MessageItem("title2","txt2"),
            MessageItem("title3","txt3"),
            MessageItem("title4","txt4")
        )
    }

}
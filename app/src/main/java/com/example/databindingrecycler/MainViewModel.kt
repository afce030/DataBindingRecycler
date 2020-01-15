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

    fun changeData(){

        deleteData()

        items.apply { value = listOf(
                MessageItem("title1","txt${(1..200).random()}"),
                MessageItem("title2","txt${(1..200).random()}"),
                MessageItem("title3","txt${(1..200).random()}"),
                MessageItem("title4","txt${(1..200).random()}")
            )
        }

    }

    private fun deleteData() {
        items.apply { value = listOf() }
    }

}
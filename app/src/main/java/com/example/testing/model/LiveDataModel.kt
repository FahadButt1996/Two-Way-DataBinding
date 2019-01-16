package com.example.testing.model

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.widget.Button

class LiveDataModel {
    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()

    fun changeLastName(view : Button){
        Log.d("Class Name" , "Model")
        this.lastName.postValue("\n\nChanged from Function")
    }
}
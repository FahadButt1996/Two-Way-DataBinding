package com.example.testing.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import android.widget.Button
import com.example.testing.BR

class Model : BaseObservable() {

    var firstName: String = ""
        @Bindable()
        get() = field
        set(value: String) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    var lastName : String = ""
    @Bindable()
    get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.lastName)
    }

    fun changeLastName(view : Button){
        Log.d("Class Name" , "Model")
        this.lastName = "\n\nChanged from Function"
        notifyPropertyChanged(BR.lastName)
    }
}
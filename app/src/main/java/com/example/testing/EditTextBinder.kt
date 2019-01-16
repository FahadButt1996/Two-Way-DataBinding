package com.example.testing

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText

class EditTextBinder {

    companion object {

        @BindingAdapter(value = ["bindingValueAttrChanged"])
        @JvmStatic
        fun setValue(text: EditText, listener: InverseBindingListener) {
            Log.d("setValue", "agya")
            if (listener != null) {
                text.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                        listener.onChange()
                    }

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    }
                })
            }
        }


        @BindingAdapter("bindingValue")
        @JvmStatic
        fun setBindingValue(value: EditText, observableString: String) {
            Log.d("setBindingValue", " here it is")
        }


        @InverseBindingAdapter(attribute = "bindingValue")
        @JvmStatic
        fun getBindindValue(value: EditText): String {
            Log.d("getBindindValue", "agya")
            return value.text.toString()
        }
    }
}

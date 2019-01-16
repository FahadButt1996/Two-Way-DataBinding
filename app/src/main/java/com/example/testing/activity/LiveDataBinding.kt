package com.example.testing.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.testing.interfaces.ButtonClick
import com.example.testing.model.LiveDataModel
import com.example.testing.R
import com.example.testing.appToolBar
import com.example.testing.databinding.ActivityLivedataBindingBinding
import com.example.testing.navigate
import kotlinx.android.synthetic.main.activity_livedata_binding.*

class LiveDataBinding : AppCompatActivity() , ButtonClick {

    override fun buttonClicked(value: Button) {
        Toast.makeText(this@LiveDataBinding , "Value coming from activity_liveData_binding XML" +
                "\n" +
                "\n " + value.text , Toast.LENGTH_SHORT).show()
    }

    lateinit var binding: ActivityLivedataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LiveDataBinding, R.layout.activity_livedata_binding)
        var data = LiveDataModel()
        data.firstName.postValue("Muhammad Fahad ")
        data.lastName.postValue("Waqar")
        binding.model = data
        binding.buttonClick = this

        // important to setLifeCycleOwner if you are goind to use live Data
        binding.setLifecycleOwner(this)

        appToolBar(this@LiveDataBinding , live_toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                navigate<MainActivity>()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        navigate<MainActivity>()
    }
}
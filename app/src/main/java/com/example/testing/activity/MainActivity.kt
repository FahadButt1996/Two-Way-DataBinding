package com.example.testing.activity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.example.testing.interfaces.ButtonClick
import com.example.testing.model.Model
import com.example.testing.R
import com.example.testing.appToolBar
import com.example.testing.databinding.ActivityMainBinding
import com.example.testing.navigate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , ButtonClick {

    override fun buttonClicked(value : Button) {
        Toast.makeText(this@MainActivity , "Value coming from activity_main XML is ::\n\n " + value.text , Toast.LENGTH_SHORT).show()
        navigate<LiveDataBinding>()
    }

    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        val model = Model()
        model.firstName = "Muhammad Fahad "
        model.lastName = "Waqar"
        mainBinding.model = model

        mainBinding.buttonClick = this

        appToolBar(this@MainActivity, obs_toolbar ,false ,false)
    }


}

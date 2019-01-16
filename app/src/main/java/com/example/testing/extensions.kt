package com.example.testing

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.example.testing.model.IntentParams

inline fun <reified T : Activity> Activity.navigate(params: List<IntentParams> = emptyList()) {
    val intent = Intent(this, T::class.java)
    for (parameter in params) {
        intent.putExtra(parameter.key, parameter.value)
    }
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    startActivity(intent)
    finish()
}

fun appToolBar(activity: Context, toolbar: Toolbar?, isSetDisplayHomeAsUpEnabled: Boolean = true
               , isSetDisplayShowHomeEnabled: Boolean = true, isSetDisplayShowTitleEnabled: Boolean = false): Unit {

    (activity as AppCompatActivity).setSupportActionBar(toolbar!!)
    activity.supportActionBar!!.setDisplayHomeAsUpEnabled(isSetDisplayHomeAsUpEnabled)
    activity.supportActionBar!!.setDisplayShowHomeEnabled(isSetDisplayShowHomeEnabled)
    activity.supportActionBar!!.setDisplayShowTitleEnabled(isSetDisplayShowTitleEnabled)
}
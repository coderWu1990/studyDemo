package com.wd.ktdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.ktdemo.activity.SpinnerActivity
import com.wd.ktdemo.basicuse.coroutine.MainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        startActivity(Intent(this,SpinnerActivity::class.java))
        startActivity(Intent(this,MainActivity2::class.java))
    }
}
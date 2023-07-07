package com.wd.ktdemo.basicuse.coroutine

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.wd.ktdemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @author wudi
 * @desc
 * @time 2023-02-22 20:04
 */
class MainActivity2 : AppCompatActivity() {

    val userServiceApi: UserServiceApi by lazy {
        val retrofit = Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor {
                it.proceed(
                    it.request()
                ).apply {
                    Log.d("json", "request:${code()}")
                }
            }.build()).baseUrl("https://www.wanandroid.com/friend/").addConverterFactory(
                MoshiConverterFactory.create()
            )
            .build()
        retrofit.create(UserServiceApi::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        var button = findViewById<Button>(R.id.button)
        var text = findViewById<TextView>(R.id.text)
        button.also {
            it.setOnClickListener {
                // 协程构建器         主线程
                GlobalScope.launch(Dispatchers.Main) {
                    //任务调度器    子线程
                    val user = withContext(Dispatchers.IO) {
                        userServiceApi.User()
                    }
                    text.text = "address:${user}"
                }
//                GlobalScope.launch {
//                    var user= withContext(Dispatchers.IO){
//                        userServiceApi.User()
//                    }
//                }
            }
        }
    }
}
package com.wd.ktdemo.basicuse.coroutine

import retrofit2.http.GET

/**
 * @author wudi
 * @desc
 * @time 2023-02-22 20:00
 */
interface UserServiceApi {
    @GET("json")
    //挂起
    suspend fun User(): User
}
package com.wd.ktdemo.basicuse.coroutine

/**
 * @author wudi
 * @desc
 * @time 2023-02-22 19:58
 */
data class User(
    val data: List<Data>, val errorCode: Int, val errorMsg: String
)

data class Data(
    val category: String,
    val icon: String,
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)



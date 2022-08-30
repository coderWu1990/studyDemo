package com.wd.ktdemo.test

/**
 * @author wudi
 * @desc
 * @time 2022-08-29 13:48
 */
class TestMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val text = """
                |多行字符串
                |编程狮
                |多行字符串
                |W3cschool"""
            println(text)    // 前置空格删除了 .trimMargin()
        }
    }

}
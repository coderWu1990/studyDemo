package com.wd.ktdemo.basicuse.list

/**
 * @author wudi
 * @desc
 * @time 2023-02-02 18:22
 */
class ListTest {
    companion object{
        @JvmStatic
        fun main(array: Array<String>){
            var list=ArrayList<String>()
            list.add("aa")
            list.add("bb")
            list.add("bb")
            list.add("bb")
            for (it in list){
                println("list=$it")
            }
            list.removeAt(0)
            println("list=${list.size}")
        }
    }
}
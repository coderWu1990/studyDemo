package com.wd.ktdemo.basicuse.map

/**
 * @author wudi
 * @desc
 * @time 2023-02-02 18:14
 */
class MapTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //不可变集合
            var map = mapOf("wudi" to 14, "zsf" to 23, "haha" to 25)
            println(map)
            //可变集合
            var mutableMap = mutableMapOf<String, String>()
            mutableMap.put("zhangsan", "ssdsf")
            mutableMap["lisi"] = "sdf"
            println(mutableMap)
            //过滤
            println(map.all { it.key.equals("haha") })
            println(map.any { it.key.equals("haha") })
            println("in map"+ ("14" in map))
            println("wudi" !in map)

            var filterMap=map.filter { 23 <= it.value }
            println(filterMap)
            println(map.maxByOrNull { it.key })
            println(map.maxByOrNull { it.value })

            for (key in map.keys){
                println("key=$key")
            }

            for (value in map.values){
                println("value=$value")
            }

            map.forEach({ println(it.key+" <> "+it.value) })
        }
    }
}
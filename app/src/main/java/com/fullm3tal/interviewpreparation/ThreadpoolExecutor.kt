package com.fullm3tal.interviewpreparation

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    fixThreadPool()
}

fun fixThreadPool() {
    val list = arrayListOf<Runnable>()
    for (i in 1..10000) {
        val runnable = Runnable {
            var j = 0
            for (k in 1..10000000) {
                j += k
            }
            println("Task Count: $i | Thread name: ${Thread.currentThread().name} | Sum: -> " + j)
        }
        list.add(runnable)
    }
    val executor = Executors.newFixedThreadPool(12)
    val startTime = System.currentTimeMillis()
    list.forEach {
        executor.execute(it)
    }
    executor.shutdown()
    executor.awaitTermination(120, TimeUnit.SECONDS)
    val endTime = System.currentTimeMillis()
    println("Total time taken: ${endTime - startTime}")
}

package com.fullm3tal.interviewpreparation

import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    mainThreadWithCoroutine()
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

fun mainThreadWithCoroutine() {
    var sum = 0L
    runBlocking {
        println("Thread: " + Thread.currentThread().name)
        for (i in 1..10000) {
            launch {
                val startTime = System.currentTimeMillis()
                var j = 0
                for (k in 1..10000000) {
                    j += k
                }
                println("Task Count: $i | Thread name: ${Thread.currentThread().name} | Sum: -> " + j)
                val endTime = System.currentTimeMillis()
                sum += (endTime - startTime)
            }
        }
        println("Total time taken: $sum")
    }
}

fun singleThread() {
    var sum = 0L
    val thread = Thread {
        println("Thread: " + Thread.currentThread().name)
        val startTime = System.currentTimeMillis()
        for (i in 1..10000) {
            var j = 0
            for (k in 1..10000000) {
                j += k
            }
            println("Task Count: $i | Thread name: ${Thread.currentThread().name} | Sum: -> " + j)
        }
        val endTime = System.currentTimeMillis()
        println("Total time taken: ${endTime - startTime}")
    }
    thread.start()
}

package com.fullm3tal.interviewpreparation

fun main() {
    deadlock()
}

fun deadlock () {
    val resource1 = Any()
    val resource2 = Any()
    val thread1 = Thread {
        synchronized(resource1) {
            println("Thread 1: Holding resource 1...")
            try {
                Thread.sleep(100)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println("Thread 1: Waiting for resource 2...")
            synchronized(resource2) { println("Thread 1: Acquired resource 2.") }
        }
    }
    val thread2 = Thread {
        synchronized(resource2) {
            println("Thread 2: Holding resource 2...")
            try {
                Thread.sleep(100)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println("Thread 2: Waiting for resource 1...")
            synchronized(resource1) { println("Thread 2: Acquired resource 1.") }
        }
    }
    thread1.start()
    thread2.start()
}
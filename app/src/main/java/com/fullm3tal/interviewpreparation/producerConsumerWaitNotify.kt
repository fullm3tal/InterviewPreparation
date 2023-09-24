package com.fullm3tal.interviewpreparation

import java.util.LinkedList
import java.util.Objects
import java.util.concurrent.locks.ReentrantLock

fun main() {

    val queue = ThreadBlockingQueue(LinkedList<String>(), 10)
    val producer = Runnable {
        while (true) {
            queue.put("data")
        }
    }
    Thread(producer).start()
    Thread(producer).start()
    val consumer = Runnable {
        while (true) {
            val data: String = queue.take()
            println("Data pulled out of the queue: $data")
        }
    }
    Thread(consumer).start()
    Thread(consumer).start()
    Thread.sleep(10000)
}

class ThreadBlockingQueue<E>(private val queue: LinkedList<E>, private val max: Int = 16) {

    private val lock1 = Object()
    private val lock2 = Object()
    private val notEmpty = Object()
    private val notFull = Object()
    fun put(item: E) {
        synchronized(lock1) {
            try {
                while (queue.size == max) {
                    notFull.wait()
                }
                queue.add(item)
                notEmpty.notifyAll()
            } finally {
            }
        }
    }

    fun <E> take(): E {
        synchronized(lock2) {
            try {
                while (queue.size == 0) {
                    notEmpty.wait()
                }
                val item: E = queue.remove() as E
                notFull.notifyAll()
                return item
            } finally {

            }
        }
    }

}
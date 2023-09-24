package com.fullm3tal.interviewpreparation

import java.util.LinkedList
import java.util.concurrent.locks.ReentrantLock
fun main() {

    val queue = CustomBlockingQueue(LinkedList<String>(),10)
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

class CustomBlockingQueue<E>(private val queue: LinkedList<E>, private val max: Int = 16) {

    private val lock = ReentrantLock(true)
    private val notEmpty = lock.newCondition()
    private val notFull = lock.newCondition()
    fun put(item: E) {
        lock.lock()
        try {
            while(queue.size == max) {
                notFull.await()
            }
            queue.add(item)
            notEmpty.signalAll()
        } finally {
            lock.unlock()
        }
    }

    fun <E> take(): E {
        lock.lock()
        try {
            while (queue.size == 0) {
                notEmpty.await()
            }
            val item: E = queue.remove() as E
            notFull.signalAll()
            return item
        } finally {
            lock.unlock()
        }
    }

}
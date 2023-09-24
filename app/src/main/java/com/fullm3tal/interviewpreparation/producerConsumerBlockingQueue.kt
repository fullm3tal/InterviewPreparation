package com.fullm3tal.interviewpreparation

import java.util.concurrent.ArrayBlockingQueue


fun main() {

    val queue = ArrayBlockingQueue<String>(10)

    val producer = Runnable {
        while (true) {
            queue.put("data")
        }
    }

    Thread(producer).start()
    Thread(producer).start()

    val consumer = Runnable {
        while (true) {
            val data = queue.take()
            println("Data pulled out of the queue: $data")
        }
    }

    Thread(consumer).start()
    Thread(consumer).start()

    Thread.sleep(10000)

}
package com.fullm3tal.interviewpreparation

fun main() {
    raceConditionSolved()
}
fun raceCondition() {
    var number = 0
    val runnable = Runnable {
        for (i in 1..1000) {
            number++;
        }
    }
    val thread1 = Thread(runnable)
    val thread2 = Thread(runnable)
    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
    print(number)
}

fun raceConditionSolved() {
    val sync = "Hello"
    var number = 0
    val runnable = Runnable {
        for (i in 1..1000) {
            synchronized(sync) {
                number++
            }
        }
    }
    val thread1 = Thread(runnable)
    val thread2 = Thread(runnable)
    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
    print(number)
}
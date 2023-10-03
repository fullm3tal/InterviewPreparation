package com.fullm3tal.interviewpreparation

import kotlin.properties.ReadOnlyProperty
import kotlin.random.Random
import kotlin.reflect.KProperty

class RandomInt : ReadOnlyProperty<Any, Int> {
    override fun getValue(thisRef: Any, property: KProperty<*>): Int {
        return Random.nextInt(1, 10)
    }
}

class App {
    val number by RandomInt()
}

fun main() {
    val app = App()
    println(app.number)
    println(app.number)
}

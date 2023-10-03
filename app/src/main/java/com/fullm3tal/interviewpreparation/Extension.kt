package com.fullm3tal.interviewpreparation

fun String.shout() : String{
    return uppercase()
}

fun call(greet : String.(String) -> Unit) {
    "Hello".greet("Jane")
}

fun callNew(greet :  String.(String) -> Unit) {
    "Hello".greet("Jane")
}

fun main() {
println("Hello".shout() )
    call {
        println("${this.uppercase()} $it")
    }
}
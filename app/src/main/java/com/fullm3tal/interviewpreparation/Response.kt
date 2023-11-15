package com.fullm3tal.interviewpreparation

fun main() {
    val person = Person("Ram", 20)
    val (name, age) = person
    println("$name : $age")
    val normalPerson = NormalPerson("Ram", 20)
//    val (name1, age1) = normalPerson   Not Possible
}
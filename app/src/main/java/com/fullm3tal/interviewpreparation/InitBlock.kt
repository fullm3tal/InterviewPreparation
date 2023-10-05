package com.fullm3tal.interviewpreparation

class Init( var fullName: String) {

    init {
        fullName+= "Kumar"
    }
    constructor( firstName: String, lastName: String): this(firstName) {
        fullName += lastName
    }
}

fun main() {

    println(Init("Ram", "Sharma").fullName)
}
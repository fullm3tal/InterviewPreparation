package com.fullm3tal.interviewpreparation

sealed class Animal {

    data class Dog(val name: String) : Animal()
    data class Cat(val name: String) : Animal()

}

class Dog {

}

fun main(){
    val dog = Animal.Dog("Moti")
    print(dog.name)
}
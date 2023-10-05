package com.fullm3tal.interviewpreparation

data class Money(val amount: Int) {

    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }

    operator fun times(other: Money): Money {
        return Money(this.amount * other.amount)
    }

}

fun main() {
    val money1 = Money(100)
    val money2 = Money(200)

    val money = 100
    money.plus(100)

    val totalMoney = money1 * money2

    println("Total money: $totalMoney") // Output: Total money: Money(amount=300)
}
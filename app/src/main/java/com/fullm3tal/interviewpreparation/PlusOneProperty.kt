package com.fullm3tal.interviewpreparation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PlusOneProperty : ReadWriteProperty<Any, Int> {

    private  var mValue = 0
    override fun getValue(thisRef: Any, property: KProperty<*>): Int {
        return mValue
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        mValue = value + 1
    }
}

class  PlusApp {

    var data by PlusOneProperty()

}

fun main() {

    val plus =  PlusApp()
    plus.data = 10

    print(plus.data)

}

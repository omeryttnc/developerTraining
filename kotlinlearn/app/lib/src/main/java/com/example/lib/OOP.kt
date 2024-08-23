package com.example.lib

import java.util.Locale

class Child(childName: String, childCategory: String) : OOP(name = childName, category = childCategory) {
    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

}


open class OOP(val name: String, val category: String) {
    var device = "Android $name"
        get() = field.uppercase(Locale.ROOT)
        set(value) {
            field = value.lowercase()
        }

    constructor(name: String, category: String, status: Int) : this(name, category) {
        device = when (status) {
            0 -> "Android"
            else -> "IOS"
        }
    }

    fun turnOn() {
        println("turned on $name $category $device")
    }
}

fun main() {
    val oop = OOP(name = "oo", category = "ddd", status = 2)
    oop.turnOn()

    println(oop.device)
}

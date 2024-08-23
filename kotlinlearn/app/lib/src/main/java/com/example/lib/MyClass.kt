package com.example.lib

import com.sun.tools.javac.Main

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages > 99) {
        println(
            "You have $numberOfMessages notifications.\n" +
                    "Your phone is blowing up! You have 99+ notifications."
        )
    } else {
        println("You have 51 notifications.")
    }
}
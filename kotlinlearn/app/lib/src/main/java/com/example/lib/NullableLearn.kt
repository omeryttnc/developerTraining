package com.example.lib

fun main(){
    var name:String?="omer"
    println(name?.length)
    println(name!!.length)
    if (name != null) {

    }
    name= null
    println(name)
}
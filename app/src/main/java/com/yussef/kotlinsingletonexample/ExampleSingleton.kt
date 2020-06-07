package com.yussef.kotlinsingletonexample

import com.yussef.kotlinsingletonexample.models.User

object ExampleSingleton {

    val singletonUser: User by lazy{
        User("yussefsaidi@outlook.com", "yussef", "image.png")
    }


}
package com.example.myspecial.application

import org.junit.Test

// TODO: Create the multiply function with `left` and `right`
fun multiply(left: Int, right: Int = 1) : Int {
    return left * right
}

class FunctionsTest {

    @Test
    fun functionCreation() {
        // TODO: print the results of the multiply function
        println(multiply(2, 3))

        // TODO: print the results of the multiply function with named
        println(multiply(left = 2, right = 3))
    }

    @Test
    fun functionDefaultValues() {
        // TODO: print the results of the multiply function with defaults
        println(multiply(2))

        // TODO: print the results of the multiply function with named defaults
        println(multiply(left = 2))
    }
}

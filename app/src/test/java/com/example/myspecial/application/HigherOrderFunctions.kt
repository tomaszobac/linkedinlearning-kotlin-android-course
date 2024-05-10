package com.example.myspecial.application

import org.junit.Test

// operate takes `operation` as a function parameter
fun operate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

class HigherOrderFunctionsTest {

    @Test
    fun functionAsParameter1() {
        // the results of the operate function as addition
        val sum = operate(x = 5, y = 3, operation = { a, b -> a + b })
        println("Sum: $sum")
    }

    @Test
    fun functionAsParameter2() {
        // the results of the operate function as multiplication
        val product = operate(x = 5, y = 3) { a, b -> a * b }
        println("Product: $product")
    }
}

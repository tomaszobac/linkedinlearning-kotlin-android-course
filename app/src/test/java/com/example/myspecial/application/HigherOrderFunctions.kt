package com.example.myspecial.application

import org.junit.Test

// operate takes `operation` as a function parameter
fun operate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

// makeMultiplier returns a function
fun makeMultiplier(factor: Int): (Int) -> Int {
    return { x -> x * factor }
}

class HigherOrderFunctionsTest {

    @Test
    fun functionAsParameter() {
        // the results of the operate function as addition
        val sum = operate(x = 5, y = 3, operation = { a, b -> a + b })
        println("Sum: $sum")

        // the results of the operate function as multiplication
        val product = operate(x = 5, y = 3) { a, b -> a * b }
        println("Product: $product")
    }

    @Test
    fun functionAsReturnValue() {
        // the results of the makeMultiplier function as doubling function
        val double = makeMultiplier(factor = 2)
        val doubleResult = double(3)
        println("Calling double function: $doubleResult")

        // TODO: print the results of the makeMultiplier function as tripling function

    }
}

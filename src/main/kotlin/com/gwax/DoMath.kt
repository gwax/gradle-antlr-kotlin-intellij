package com.gwax

import com.gwax.lang.Arith

fun doMath(lexer: Arith): Double {
    var op = Arith.ADDITION
    var total = 0.0
    lexer.allTokens.forEach {
        when (it.type) {
            Arith.NUMBER -> {
                when (op) {
                    Arith.ADDITION -> total += it.text.toDouble()
                    Arith.SUBTRACTION -> total -= it.text.toDouble()
                }
            }
            Arith.ADDITION, Arith.SUBTRACTION -> op = it.type
        }
    }
    return total
}
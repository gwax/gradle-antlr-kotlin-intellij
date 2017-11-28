package com.gwax

import com.gwax.lang.Arith

fun doMath(lexer: Arith): Double {
    val vocab = lexer.vocabulary
    var op = "ADDITION"
    var total = 0.0
    val tokenPairs = lexer.allTokens.map {
        t -> Pair(vocab.getSymbolicName(t.type), t.text)
    }
    for ((type, text) in tokenPairs) {
        when (type) {
            "NUMBER" -> {
                val value = text.toDouble()
                when (op) {
                    "ADDITION" -> total += value
                    "SUBTRACTION" -> total -= value
                }
            }
            else -> op = type
        }
    }
    return total
}
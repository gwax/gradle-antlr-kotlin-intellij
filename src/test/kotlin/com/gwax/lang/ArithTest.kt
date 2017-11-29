package com.gwax.lang

import com.gwax.lang.Arith
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Token
import org.junit.Test
import kotlin.test.assertEquals

class ArithTest {
    private fun lex(input: String) = Arith(CharStreams.fromString(input))
    private fun Lexer.tokenTypes() = this.allTokens.map { t -> t.type }
    private fun Lexer.symbolicNames(tokenTypes: List<Int>): List<String> = tokenTypes.map {
        this.vocabulary.getSymbolicName(it)
    }

    @Test fun parseAddition() {
        val expected = listOf(Arith.NUMBER, Arith.ADDITION, Arith.NUMBER)
        val lexer = lex("1+2.4")
        assertEquals(lexer.symbolicNames(expected),
            lexer.symbolicNames(lexer.tokenTypes()))
    }

    @Test fun parseSkipWhitespace() {
        val expected = listOf(Arith.NUMBER, Arith.SUBTRACTION, Arith.NUMBER)
        val lexer = lex("1 - 2")
        assertEquals(lexer.symbolicNames(expected),
            lexer.symbolicNames(lexer.tokenTypes()))
    }
}

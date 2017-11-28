package com.gwax.lang

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.Lexer
import org.junit.Test
import kotlin.test.assertEquals

class ArithTest {
    private fun lex(input: String) = Arith(CharStreams.fromString(input))

    private fun tokenize(lexer: Lexer): List<String> {
        val vocab = lexer.vocabulary
        return lexer.allTokens.map { t -> vocab.getSymbolicName(t.type) }
    }

    @Test fun parseAddition() {
        assertEquals(listOf("NUMBER", "ADDITION", "NUMBER"),
                tokenize(lex("1+2.4")))
    }

    @Test fun parseSkipWhitespace() {
        assertEquals(listOf("NUMBER", "SUBTRACTION", "NUMBER"),
                tokenize(lex("1 - 2")))
    }
}
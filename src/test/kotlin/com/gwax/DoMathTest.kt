package com.gwax

import com.gwax.doMath
import com.gwax.lang.Arith
import org.antlr.v4.runtime.CharStreams
import org.junit.Test
import kotlin.test.assertEquals


class DoMathTest {
    private fun lex(input: String) = Arith(CharStreams.fromString(input))

    @Test fun addSomeStuff() {
        assertEquals(2.0,
                doMath(lex("1 + 1.0")))
    }

    @Test fun someMoreMath() {
        assertEquals(1.0,
                doMath(lex("2.0 + 1 - 2.0 + 5.5 - 3.25 - 4.5 + 2.25")))
    }
}
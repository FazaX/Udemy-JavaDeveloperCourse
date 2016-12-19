package com.fazax.udemy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities utils;

    @Before
    public void setUp() {
        utils = new Utilities();
    }

    @Test
    public void everyNthChar() throws Exception {

        String entry = "hello";
        char[] source = entry.toCharArray();
        char[] expected = {'e','l'};
        int nthChar = 2;

        assertArrayEquals(expected, utils.everyNthChar(source, nthChar));
        assertNull(utils.everyNthChar(null, 2));
        assertArrayEquals(source, utils.everyNthChar(source, 10));//n - bigger than length of source
    }

    @Test
    public void removePairs() throws Exception {

        assertEquals("ABCDEF", utils.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", utils.removePairs("ABCCABDEEF"));
        assertEquals("ABCDEF", utils.removePairs("ABCDEFF"));
        assertEquals("AB8EFG", utils.removePairs("AB88EFFG"));
        assertEquals("123456", utils.removePairs("112233445566"));
        assertEquals("ZYZQB", utils.removePairs("ZYZQQB"));
        assertEquals("A", utils.removePairs("A"));
        assertEquals("", utils.removePairs(""));
        assertNull(utils.removePairs(null));
    }

    @Test
    public void converter() throws Exception {

        assertEquals(28, utils.converter(1,2));
        assertEquals(59, utils.converter(2,2));
        assertEquals(-63, utils.converter(-2,2));
        assertEquals(-61, utils.converter(-2,-2));

    }

    @Test(expected = ArithmeticException.class)
    public void converterThrowsArithmeticExceptionWhenSecondParamIsZero() throws Exception{

        utils.converter(2,0);
    }

    @Test
    public void nullIfOddLength() throws Exception {

        assertEquals("EvenLength",utils.nullIfOddLength("EvenLength"));
        assertNull(utils.nullIfOddLength("OddLength"));
    }

}
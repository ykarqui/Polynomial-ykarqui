package com.incluit.trainnings.java.ykarqui.polynomial;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PolynomialTest {

    private Polynomial pol;

    @Before
    public void setup() {
        
    }

    @Test
    public void testEmptyPolynomSize() {
        pol = new Polynomial();
        assertEquals(1 , pol.size);
    }

    @Test
    public void testEmptyPolynomValuesSize() {
        int coeffs [] = {2, 5, 7};
        pol = new Polynomial(coeffs);
        assertEquals(3 , pol.size);
    }

    @Test
    public void testEmptyPolynomCoefficientValues() {
        int coeffs [] = {2, 5, 7};
        pol = new Polynomial(coeffs);
        assertEquals(2 , pol.root.coefficient);
        assertEquals(5 , pol.root.next.coefficient);
        assertEquals(7 , pol.root.next.next.coefficient);
    }


/*
    @Test
    public void testSizeIsZeroInitially() {
        assertEquals(0, pol.getSize());
    }

    @Test
    public void testSizeIsNotZeroWhenElementsAreAdded() {
        pol.add(1);
        assertEquals(1, pol.getSize());
    }

    @Test
    public void testEmptyIsFalseWhenElementsAreAdded() {
        pol.add(1);
        assertFalse(pol.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNegativeNumbersFails() {
        pol.get(-1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetInvalidIndexFails() {
        pol.get(5);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetInvalidIndexFails2() {
        pol.get(0);
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 10; i++) {
            pol.add(i);
        }
        assertEquals(9, pol.get(9));
        assertEquals(4, pol.get(4));
        assertEquals(0, pol.get(0));
    }

    @Test
    public void testToStringEmptyList() {
        assertEquals("[]", pol.toString());
    }

    @Test
    public void testToStringNotEmptyList() {
        pol.add(3);
        assertEquals("[3, ]", pol.toString());
    }

    @Test
    public void testToStringNotEmptyList2() {
        pol.add(5);
        pol.add(3);
        assertEquals("[5, 3, ]", pol.toString());
    }

    @Test
    public void testToStringNotEmptyListTwice() {
        pol.add(5);
        pol.add(3);
        assertEquals("[5, 3, ]", pol.toString());
        assertEquals("[5, 3, ]", pol.toString());
    }

    @Test
    public void testIterate() {
        for (int i = 0; i < 10; i++) {
            pol.add(i);
        }

        int expected = 0;
        Iterator it = pol.iterator();
        while(it.hasNext()) {
            int x = (int) it.next();
            assertEquals(expected, x);
            expected++;
        }
        assertEquals(10, expected);
    }*/
}
package com.incluit.trainnings.java.ykarqui.polynomial;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class PolynomialTest {

    private Polynomial pol;

    @Before
    public void setup() {
        
    }

    @Test
    public void testEmptyPolynomSize() {
        pol = new Polynomial();
        assertEquals(1 , pol.size); // pol.size = 1  => {0x^0}
        assertEquals(0 , pol.getCoefficient(0));
    }

    @Test
    public void testEmptyPolynomValuesSize() {
        int coeffs [] = {2, 5, 7};
        pol = new Polynomial(coeffs);
        assertEquals(3 , pol.size);     // 3 == 3
        assertEquals(coeffs.length , pol.size); // 3 == 3
    }

    @Test
    public void testPolynomCoefficientValues() {
        int coeffs [] = {2, 5, 7, 8};
        pol = new Polynomial(coeffs);
        assertEquals(2 , pol.root.coefficient);
        assertEquals(5 , pol.root.next.coefficient);
        assertEquals(7 , pol.root.next.next.coefficient);
        
        assertEquals(2 , pol.getCoefficient(1));
        assertEquals(5 , pol.getCoefficient(2));
        assertEquals(7 , pol.getCoefficient(3));
        assertEquals(8 , pol.getCoefficient(4));
    }

    @Test
    public void testPolynomPowValues() {
        int coeffs [] = {2, 5, 7, 10};
        pol = new Polynomial(coeffs);
        assertEquals(1 , pol.root.exponent);
        assertEquals(2 , pol.root.next.exponent);
        assertEquals(3 , pol.root.next.next.exponent);
        assertEquals(4 , pol.root.next.next.next.exponent);
    }

    @Test
    public void testPolynomSum() {
        int a [] = {2, 5, 6};
        int b [] = {0, 0, 0};

        Polynomial pol1 = new Polynomial(a);
        Polynomial pol2 = new Polynomial(b);

        Polynomial result = pol1.add(pol2);
        
        assertEquals(0 , result.getCoefficient(1));
        //assertEquals(12 , result.getCoefficient(2));
        //assertEquals(10 , result.getCoefficient(3));
    }

    @Test
    public void testPolynomCoefficientValuesWithFunction() {
        int coeffs [] = {2, 5, 7};
        pol = new Polynomial(coeffs);
        assertEquals(2 , pol.getCoefficient(1));
        //assertEquals(5 , pol.getCoefficient(2));
    }

    @Test
    public void testPolynomSetCoefficientValuesWithFunction() {
        int coeffs [] = {2, 5};
        pol = new Polynomial(coeffs);
        pol.setCoefficient(1, 3);
        assertEquals(3 , pol.getCoefficient(1));
    }

    @Test
    public void testToStringNotEmptyPolynom() {
        int coeffs [] = {7,3,9};
        Polynomial pol = new Polynomial(coeffs);
        assertEquals("f(x)= + 7x^1 + 3x^2 + 9x^3", pol.toString());
    }

    @Test
    public void testValueOfMethod() {
        int coeffs [] = {4,3,2};
        Polynomial pol = new Polynomial(coeffs);
        
        // float point1 = 1f;
        float point2 = 2f;
        // float expectedPow1 = 9f;
        float expectedPow2 = 36f;
        double delta = 0.01;
        
        //assertEquals(expectedPow1, pol.valueOf(point1), delta);
        assertEquals(expectedPow2, pol.valueOf(point2), delta);
    }

    @Test
    public void testEqualsPolynoms() {
        int coeffs [] = {7,3,9};
        int coeffs2 [] = {7,3,9};
        Polynomial pol = new Polynomial(coeffs);
        Polynomial pol2 = new Polynomial(coeffs2);
        assertEquals(true, pol.equals(pol2));
    }

    @Test
    public void testNotEqualsPolynoms() {
        int coeffs [] = {7,3,9};
        int coeffs2 [] = {7,3,5};
        Polynomial pol = new Polynomial(coeffs);
        Polynomial pol2 = new Polynomial(coeffs2);
        assertFalse(pol.equals(pol2));
    }


}
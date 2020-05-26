package com.incluit.trainnings.java.ykarqui.polynomial;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ListaTest {

    private IList lista;

    @Before
    public void setup() {
        lista = new LinkedList();
    }

    @Test
    public void testEmptyListIsEmpty() {
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testSizeIsZeroInitially() {
        assertEquals(0, lista.size());
    }

    @Test
    public void testSizeIsNotZeroWhenElementsAreAdded() {
        lista.add(1);
        assertEquals(1, lista.size());
    }

    @Test
    public void testEmptyIsFalseWhenElementsAreAdded() {
        lista.add(1);
        assertFalse(lista.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNegativeNumbersFails() {
        lista.get(-1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetInvalidIndexFails() {
        lista.get(5);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetInvalidIndexFails2() {
        lista.get(0);
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }
        assertEquals(9, lista.get(9));
        assertEquals(4, lista.get(4));
        assertEquals(0, lista.get(0));
    }

    @Test
    public void testToStringEmptyList() {
        assertEquals("[]", lista.toString());
    }

    @Test
    public void testToStringNotEmptyList() {
        lista.add(3);
        assertEquals("[3, ]", lista.toString());
    }

    @Test
    public void testToStringNotEmptyList2() {
        lista.add(5);
        lista.add(3);
        assertEquals("[5, 3, ]", lista.toString());
    }

    @Test
    public void testToStringNotEmptyListTwice() {
        lista.add(5);
        lista.add(3);
        assertEquals("[5, 3, ]", lista.toString());
        assertEquals("[5, 3, ]", lista.toString());
    }

    @Test
    public void testIterate() {
        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }

        int expected = 0;
        Iterator it = lista.iterator();
        while(it.hasNext()) {
            int x = (int) it.next();
            assertEquals(expected, x);
            expected++;
        }
        assertEquals(10, expected);
    }
}
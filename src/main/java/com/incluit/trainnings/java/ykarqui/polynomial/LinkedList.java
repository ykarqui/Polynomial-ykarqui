package com.incluit.trainnings.java.ykarqui.polynomial;

import java.util.NoSuchElementException;

public class LinkedList implements IList {

    private Nodo root;
    private int size;

    public void add(int x) {
        Nodo n = new Nodo(x);
        if (root == null) {
            root = n;
        } else {
            Nodo p = root;
            while (p.next != null) {
                p = p.next;
            }
            p.next = n;
        }
        size ++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        Nodo p = root;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.value;
    }

    public boolean contains(int x) {
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo p = root;
        while(p != null) {
            sb.append(p.value);
            sb.append(", ");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public Iterator iterator() {
        return new ListIterator(root);
    }



    private static class ListIterator implements Iterator {

        private Nodo actual;

        public ListIterator(Nodo actual) {
            this.actual = actual;
        }

        public boolean hasNext() {
            return actual != null;
        }

        public int next() {
            int value = actual.value;
            actual = actual.next;
            return value;
        }
    }


     private static class Nodo {
        int value;
        Nodo next;

        public Nodo(int value) {
            this.value = value;
        }
    }
}

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

// 1. Polynomial(): ​ 
        //     este constructor debe crear un objeto ​ Polynomial ​ igual al polinomio 0(cero) (grado n = 0).
        // public Polynomial(){
        //     this.coefficient = 0;
        //     this.exponent = 0;
        //}
        // 2. Polynomial(int coef[]): ​ 
        //     este constructor debe crear un objeto ​ Polynomial ​ cuyo grado sea igual al tamaño del arreglo coef, 
        //     y cuyos coeficientes sean tomados uno a uno desde el mismo arreglo ​ coef ​ que entra como parámetro,
        //     en orden inverso, pero considerando que si algún casillero ​ coef[k] ​ es cero,
        //      entonces el término correspondiente en el polinomio no existe y ​ no debe agregarse ​ .
        //public Polynomial(int coef []) {
        //    Nodo nodo = new Nodo();
        //    nodo.coefficient[0] = coef[0];
        //}
        // 3. Polynomial add(Polynomial pol): 
        //     retorna un ​ Polynomial i ​ gual a la suma entre ​ this ​ y pol ​ .
        // 4. int getCoefficient(int x): ​
        //     Devuelve el valor del coeficiente del grado ​ x
        // 5. void setCoefficient(int x, int coef): 
        //     establece el valor del coeficiente de grado x al valor ​ coef
        // 6. float valueOf(float x): ​ 
        //     calcula y retorna el valor del polinomio en el punto x.
        // 7. boolean equals(Object x): ​ 
        //     retorna t ​ rue ​ si ​ this ​ es igual a ​ x ​ , y ​ false ​ en caso contrario.
        // 8. String toString(): 
        //     retorna la representación del ​ Polynomial ​ en forma de ​ String ​ .

}
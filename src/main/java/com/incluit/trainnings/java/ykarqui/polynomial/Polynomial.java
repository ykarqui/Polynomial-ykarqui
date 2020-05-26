package com.incluit.trainnings.java.ykarqui.polynomial;

import java.util.NoSuchElementException;

public class Polynomial {

    private Nodo root;
    private int size;

    public void add() {
        Nodo n = new Nodo(0,0);
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

    public void addCoef(int coef) {
        if (coef != 0) {
            Nodo n = new Nodo(coef,0);
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
    }

    public Polynomial(){
        Polynomial empty = new Polynomial();
        empty.add();
    }

    // 2. Polynomial(int coef[]): ​ 
    //     este constructor debe crear un objeto ​ Polynomial ​ cuyo grado sea igual al tamaño del arreglo coef, 
    //     y cuyos coeficientes sean tomados uno a uno desde el mismo arreglo ​ coef ​ que entra como parámetro,
    //     en orden inverso, pero considerando que si algún casillero ​ coef[k] ​ es cero,
    //      entonces el término correspondiente en el polinomio no existe y ​ no debe agregarse ​ .
    public Polynomial(int coef []) {
        Polynomial polyn = new Polynomial();
        for (int i = 0; i < coef.length; i++){
            polyn.addCoef(coef[i]);
        }
    }

    // 3. Polynomial add(Polynomial pol): 
    //     retorna un Polynomial igual a la suma entre ​this ​y pol
    public Polynomial add(Polynomial pol){
        
        Polynomial current = this;  // actual 
        Polynomial result = new Polynomial();   // parameter
        
        Nodo x = current.root.next; // actual
        Nodo y = pol.root.next; // parameter
        
        while (x != null || y != null) {
            Nodo t = null;
            
            if(x == null){ 
                t = new Nodo(y.coefficient, y.exponent);  
                y = y.next; 
            }
            else if (y == null) { 
                t = new Nodo(x.coefficient, x.exponent);  
                x = x.next; 
            }
            else if (x.exponent > y.exponent) { 
                t = new Nodo(x.coefficient, x.exponent);  
                x = x.next; 
            } 
            else if (x.exponent < y.exponent) { 
                t = new Nodo(y.coefficient, y.exponent);  
                y = y.next; 
            } 
            else {
                int coef = x.coefficient + y.coefficient;
                int exp  = x.exponent;
                x = x.next;
                y = y.next;
                if (coef == 0) continue;
                t = new Nodo(coef, exp);
            }
        
            result.root.next = t;
            result.root = result.root.next;
        }
        return result;
    }

    // 4. int getCoefficient(int x): ​
    //     Devuelve el valor del coeficiente del grado ​ x
    public int getCoefficient(int x) {
        if (x < 0) {
            throw new NoSuchElementException();
        }
        Nodo p = root;
        for (int i = 0; i < size; i++) {
            if (p.exponent == x){
                return p.coefficient;
            }
        }
        throw new NoSuchElementException();
    }

    // 5. void setCoefficient(int x, int coef): 
    //     establece el valor del coeficiente de grado x al valor ​ coef
    public void setCoefficient(int x, int coef){
        if (x < 0) {
            throw new NoSuchElementException();
        }
        Nodo p = root;
        for (int i = 0; i < size; i++) {
            if (p.exponent == x){
                p.coefficient = coef;
            }
        }
        throw new NoSuchElementException();
    }

    // 6. float valueOf(float x): ​ 
    //     calcula y retorna el valor del polinomio en el punto x.
    public float valueOf(float x) {
        float valued = 0f;
        for (int i = 0; i < size; i++){
         valued += Math.pow(root.coefficient,root.exponent);
        }
        return valued;
    }
    // 7. boolean equals(Object x): ​ 
    //     retorna true ​ si ​ this ​ es igual a ​ x ​ , y ​ false ​ en caso contrario.
    @Override
    public boolean equals(Object x) {
        return this == x;
    }


    // 8. String toString(): 
    //     retorna la representación del ​ Polynomial ​ en forma de ​ String ​ .
    @Override
    public String toString() {
        String s = "";
        for (Nodo x = root.next; x != null; x = x.next) {
            if(x.coefficient > 0) {
                s = s + " + " +   x.coefficient  + "x^" + x.exponent;
            }
            else if (x.coefficient < 0) {
                s = s + " - " + (-x.coefficient) + "x^" + x.exponent;
            }
        }
        return s;
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
            int coeff = actual.coefficient;
            actual = actual.next;
            return coeff;
        }
    }


    private static class Nodo {
        int coefficient;
        int exponent;
        Nodo next;
        Nodo(int coefficient, int exponent){
            this.coefficient = coefficient;
            this.exponent = exponent;
        }
    }

    
}
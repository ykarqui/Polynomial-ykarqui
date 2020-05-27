package com.incluit.trainnings.java.ykarqui.polynomial;

import java.util.NoSuchElementException;

public class Polynomial implements IPolynomial{

    Nodo root;
    int size;
    Nodo first = root;
	Nodo last  = first;

    // 1. Polynomial(): ​ 
    //     este constructor debe crear un objeto ​ Polynomial ​ igual al polinomio 0(cero) (grado n = 0).
    public Polynomial(){
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

    // 2. Polynomial(int coef[]): ​ 
    //     este constructor debe crear un objeto ​ Polynomial ​ cuyo grado sea igual al tamaño del arreglo coef, 
    //     y cuyos coeficientes sean tomados uno a uno desde el mismo arreglo ​ coef ​ que entra como parámetro,
    //     en orden inverso, pero considerando que si algún casillero ​ coef[k] ​ es cero,
    //      entonces el término correspondiente en el polinomio no existe y ​ no debe agregarse ​ .
    public Polynomial(int coef []) {
        for (int i = 0; i < coef.length; i++){
            Nodo n = new Nodo(coef[i], i+1);
            size ++;
            if (root == null) {
                root = n;
            } else {
                Nodo p = root;
                while (p.next != null) {
                    p = p.next;
                }
            p.next = n;
            }
        }
    }

    // 3. Polynomial add(Polynomial pol): 
    //     retorna un Polynomial igual a la suma entre ​this ​y pol
    public Polynomial add(Polynomial pol){
        return pol;
    }

    // 4. int getCoefficient(int x): ​
    //     Devuelve el valor del coeficiente del grado ​ x
    public int getCoefficient(int x) {
    	Nodo n = root;
    	while (n != null){
        	if (n.exponent == x){
                return n.coefficient;
            }
            n = n.next;
        }
        throw new NoSuchElementException();
    }

    // 5. void setCoefficient(int x, int coef): 
    //     establece el valor del coeficiente de grado x al valor ​ coef
    public void setCoefficient(int x, int coef){
        Nodo p = root;
        while (p.next != null){
            if (p.exponent == x){
                p.coefficient = coef;
                return;
            }
            p = p.next;
        }
        throw new NoSuchElementException();
    }

    // 6. float valueOf(float x): ​ 
    //     calcula y retorna el valor del polinomio en el punto x.
    public float valueOf(float x) {
        float valued = 0f;
        while(root != null){
         valued += (root.coefficient * (Math.pow( x , root.exponent )));
         root = root.next;
        }
        return valued;
    }
    // 7. boolean equals(Object x): ​ 
    //     retorna true ​ si ​ this ​ es igual a ​ x ​ , y ​ false ​ en caso contrario.
    @Override
    public boolean equals(Object x) {
        Nodo p = root;
        Polynomial compared;
        if (x instanceof Polynomial) {
            compared = (Polynomial) x;
            while (p != null){
                if (p.coefficient != compared.root.coefficient || p.exponent != compared.root.exponent){
                    return false;
                }
                p = p.next;
                compared.root = compared.root.next;
            }
        }
        
        return true;
    }


    // 8. String toString(): 
    //     retorna la representación del ​ Polynomial ​ en forma de ​ String ​ .
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("f(x)=");
        Nodo p = root;
        while(p != null) {
            if(p.coefficient > 0) {
                sb.append(" + ");
                sb.append(p.coefficient);
                sb.append("x^"); 
                sb.append(p.exponent);
            }
            else if (p.coefficient < 0) {
                sb.append(" - ");
                sb.append(p.coefficient);
                sb.append("x^"); 
                sb.append(p.exponent);
            }
            p = p.next;
        }
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
            int coeff = actual.coefficient;
            actual = actual.next;
            return coeff;
        }
    }


    static class Nodo {
        int coefficient;
        int exponent;
        Nodo next;
        Nodo(int coefficient, int exponent){
            this.coefficient = coefficient;
            this.exponent = exponent;
        }
    }

    
}
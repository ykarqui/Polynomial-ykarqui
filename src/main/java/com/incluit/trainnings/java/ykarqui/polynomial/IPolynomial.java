package com.incluit.trainnings.java.ykarqui.polynomial;

public interface IPolynomial {
	public Polynomial add(Polynomial pol);

    public int getCoefficient(int x);

    public void setCoefficient(int x, int coef);

    public float valueOf(float x);
    
    public boolean equals(Object x);

    public String toString();
}

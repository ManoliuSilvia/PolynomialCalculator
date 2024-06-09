package org.assig.DataModels;

public class Monomial {
    private int degree;
    private float coefficient;

    public Monomial(int degree, float coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }
    public float getCoefficient() {
        return coefficient;
    }
    public int getDegree() {
        return degree;
    }
}
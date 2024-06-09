package org.assig.BusinessLogic;

import org.assig.DataModels.Monomial;
import org.assig.DataModels.Polynomial;

import java.util.Map;

public class PolynomialMultiplication {
    public static Polynomial multiplication(Polynomial a, Polynomial b) {
        Polynomial c = new Polynomial();
        for (Monomial monomialA : a.getMonomials().values()) {
            for (Monomial monomialB : b.getMonomials().values()) {
                int degree = monomialA.getDegree() + monomialB.getDegree();
                float coefficient = monomialA.getCoefficient() * monomialB.getCoefficient();
                Monomial auxMonomial = new Monomial(degree, coefficient);
                c.addMonomial(auxMonomial);
            }
        }
        return c;
    }
}

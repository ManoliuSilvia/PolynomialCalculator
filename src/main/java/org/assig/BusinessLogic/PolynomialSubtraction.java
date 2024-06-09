package org.assig.BusinessLogic;

import org.assig.DataModels.Monomial;
import org.assig.DataModels.Polynomial;

import java.util.Map;

public class PolynomialSubtraction {
    public static Polynomial subtraction(Polynomial a, Polynomial b){
        Polynomial c = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : a.getMonomials().entrySet()){
            c.addMonomial(entry.getValue());
        }
        for(Map.Entry<Integer, Monomial> entry : b.getMonomials().entrySet()){
            int degree = entry.getValue().getDegree();
            float negatedCoefficient = -entry.getValue().getCoefficient();
            Monomial negatedMonomial = new Monomial(degree,negatedCoefficient);
            c.addMonomial(negatedMonomial);
        }
        return c;
    }
}

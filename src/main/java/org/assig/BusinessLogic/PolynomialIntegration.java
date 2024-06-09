package org.assig.BusinessLogic;

import org.assig.DataModels.Monomial;
import org.assig.DataModels.Polynomial;

public class PolynomialIntegration {
    public static Polynomial integration(Polynomial a) {
        Polynomial c = new Polynomial();
        for(Monomial monomial: a.getMonomials().values()){
            int newDegree = monomial.getDegree() + 1;
            float newCoefficient = monomial.getCoefficient() / (newDegree);
            if(Double.isFinite((newCoefficient))) {
                Monomial auxMonomial = new Monomial(newDegree, newCoefficient);
                c.addMonomial(auxMonomial);
            }
            else{
                Monomial auxMonomial = new Monomial(0,newCoefficient);
                c.addMonomial(auxMonomial);
            }
        }
        return c;
    }
}

package org.assig.BusinessLogic;

import org.assig.DataModels.Monomial;
import org.assig.DataModels.Polynomial;

public class PolynomialDerivative {
    public static Polynomial derivative(Polynomial a) {
        Polynomial c = new Polynomial();
        for(Monomial monomial: a.getMonomials().values()){
            int degree = monomial.getDegree()-1;
            float coefficient = monomial.getCoefficient() * monomial.getDegree() ;
            if( degree >= 0){
                Monomial auxMonomial = new Monomial(degree,coefficient);
                c.addMonomial(auxMonomial);
            }
        }
        return c;
    }
}

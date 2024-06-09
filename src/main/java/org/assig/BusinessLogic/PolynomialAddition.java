package org.assig.BusinessLogic;

import org.assig.DataModels.Monomial;
import org.assig.DataModels.Polynomial;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PolynomialAddition {

    public static Polynomial addition(Polynomial a, Polynomial b){
        Polynomial c = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : a.getMonomials().entrySet()){
            c.addMonomial(entry.getValue());
        }
        for(Map.Entry<Integer, Monomial> entry : b.getMonomials().entrySet()){
            c.addMonomial(entry.getValue());
        }
        return c;
    }
}

package org.assig.DataModels;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private Map<Integer,Monomial> monomials;
    public Polynomial() {
        monomials = new TreeMap<>();
    }
    public Polynomial(Map<Integer, Monomial> monomials) {
        this.monomials = monomials;
    }
    public void addMonomial(Monomial auxMonomial){
        int degree = auxMonomial.getDegree();
        if(monomials.containsKey(degree)){
            Monomial oldMonomial = monomials.get(degree);
            float newCoefficient = oldMonomial.getCoefficient() + auxMonomial.getCoefficient();
            Monomial newMonomial = new Monomial(degree,newCoefficient);
            monomials.put(degree, newMonomial);
        }
        else{
            monomials.put(degree,auxMonomial);
        }
        if(monomials.get(degree).getCoefficient() == 0 ){
            monomials.remove(degree);
        }
    }
    public Map<Integer, Monomial> getMonomials() {
        return monomials;
    }
}
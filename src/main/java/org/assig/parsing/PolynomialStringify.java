package org.assig.parsing;
import org.assig.DataModels.Monomial;
import org.assig.DataModels.Polynomial;

import java.util.*;

public class PolynomialStringify {
    public static String stringify(Polynomial polynomial) {
        StringBuilder sb = new StringBuilder();
        List<Integer> keys = new ArrayList<>(polynomial.getMonomials().keySet());
        Collections.sort(keys,Collections.reverseOrder());
        for (int key : keys) {
            Monomial monomial = polynomial.getMonomials().get(key);
            float coefficient = monomial.getCoefficient();
            int degree = monomial.getDegree();
            if (coefficient > 0 && sb.length() > 0) {
                sb.append("+");
            }
            if (degree == 0) {
                sb.append(coefficient);
            } else if (degree == 1) {
                sb.append(coefficient).append("x");
            } else {
                sb.append(coefficient).append("x^").append(degree);
            }
        }
        return sb.toString();
    }
}

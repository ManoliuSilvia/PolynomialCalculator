package org.assig.parsing;
import org.assig.DataModels.Monomial;
import org.assig.DataModels.Polynomial;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PolynomialParse {
    public static Polynomial parse(String polynomialString) {
        Polynomial polynomial = new Polynomial();
        Pattern pattern = Pattern.compile("([+-]?\\d*\\.?\\d*)?[xX]\\^(\\d+)");
        Matcher matcher = pattern.matcher(polynomialString);
        int lastIndex = 0;
        while (matcher.find()) {
            if (matcher.start() != lastIndex) {
                throw new NumberFormatException("Invalid monomial string: " + polynomialString.substring(lastIndex, matcher.start()));
            }
            float coefficient;
            String coefficientString = matcher.group(1);
            if (coefficientString == null || coefficientString.equals("+") || coefficientString.equals("")) {
                coefficient = 1.0f;
            } else if (coefficientString.equals("-")) {
                coefficient = -1.0f;
            } else {
                coefficient = Float.parseFloat(coefficientString);
            }
            int degree = Integer.parseInt(matcher.group(2));
            polynomial.addMonomial(new Monomial(degree, coefficient));
            lastIndex = matcher.end();
        }
        if (lastIndex != polynomialString.length()) {
            throw new NumberFormatException("Invalid monomial string: " + polynomialString.substring(lastIndex));
        }
        return polynomial;
    }
}

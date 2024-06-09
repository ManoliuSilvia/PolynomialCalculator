import org.assig.BusinessLogic.*;
import org.assig.DataModels.Monomial;
import org.assig.DataModels.Polynomial;
import org.assig.parsing.PolynomialStringify;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class OpTest {
    @Test
    public void addTest(){
        Polynomial p1 = new Polynomial() ;
        Monomial m1 = new Monomial(4,1.0f);
        Monomial m2 = new Monomial(3, 3.5f);
        Monomial m3 = new Monomial(1, 3.0f);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p1.addMonomial(m3);
        Polynomial p2 = new Polynomial();
        Monomial m4 = new Monomial(4, 3.0f);
        Monomial m5 = new Monomial(2, 2.0f);
        p2.addMonomial(m4);
        p2.addMonomial(m5);
        p2.addMonomial(m3);
        Polynomial result = PolynomialAddition.addition(p1,p2);
        assertEquals("4.0x^4+3.5x^3+2.0x^2+6.0x", PolynomialStringify.stringify(result));
    }
    @Test
    public void subTest(){
        Polynomial p1 = new Polynomial() ;
        Monomial m1 = new Monomial(4,1.0f);
        Monomial m2 = new Monomial(3, 3.5f);
        Monomial m3 = new Monomial(1, 3.0f);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p1.addMonomial(m3);
        Polynomial p2 = new Polynomial();
        Monomial m4 = new Monomial(4, 3.0f);
        Monomial m5 = new Monomial(2, 2.0f);
        p2.addMonomial(m4);
        p2.addMonomial(m5);
        p2.addMonomial(m3);
        Polynomial result = PolynomialSubtraction.subtraction(p1,p2);
        assertEquals("-2.0x^4+3.5x^3-2.0x^2", PolynomialStringify.stringify(result));
    }
    @Test
    public void multiplyTest(){
        Polynomial p1 = new Polynomial() ;
        Monomial m1 = new Monomial(4,1.0f);
        Monomial m2 = new Monomial(3, 3.5f);
        Monomial m3 = new Monomial(1, 3.0f);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p1.addMonomial(m3);
        Polynomial p2 = new Polynomial();
        Monomial m4 = new Monomial(4, 3.0f);
        Monomial m5 = new Monomial(2, 2.0f);
        p2.addMonomial(m4);
        p2.addMonomial(m5);
        p2.addMonomial(m3);
        Polynomial result = PolynomialMultiplication.multiplication(p1,p2);
        assertEquals("3.0x^8+10.5x^7+2.0x^6+19.0x^5+10.5x^4+6.0x^3+9.0x^2", PolynomialStringify.stringify(result));
    }
    @Test
    public void derivTest(){
        Polynomial p1 = new Polynomial() ;
        Monomial m1 = new Monomial(4,1.0f);
        Monomial m2 = new Monomial(3, 3.5f);
        Monomial m3 = new Monomial(1, 3.0f);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p1.addMonomial(m3);
        Polynomial result = PolynomialDerivative.derivative(p1);
        assertEquals("4.0x^3+10.5x^2+3.0", PolynomialStringify.stringify(result));
    }
    @Test
    public void integrTest(){
        Polynomial p1 = new Polynomial() ;
        Monomial m1 = new Monomial(4,1.0f);
        Monomial m2 = new Monomial(3, 3.5f);
        Monomial m3 = new Monomial(1, 3.0f);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p1.addMonomial(m3);
        Polynomial result = PolynomialIntegration.integration(p1);
        assertEquals("0.2x^5+0.875x^4+1.5x^2", PolynomialStringify.stringify(result));
    }
}

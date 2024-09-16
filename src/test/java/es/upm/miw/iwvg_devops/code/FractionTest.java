package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FractionTest {

    @Test
    public void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        Assertions.assertEquals(1, fraction.getNumerator());
        Assertions.assertEquals(1, fraction.getDenominator());
    }

    @Test
    public void testDecimal() {
        Fraction fraction = new Fraction(2, 3);
        Assertions.assertEquals((double) 2 / 3, fraction.decimal(), 1e-5);
        fraction.setDenominator(0);
        Assertions.assertTrue(Double.isInfinite(fraction.decimal()));
        fraction.setNumerator(0);
        Assertions.assertTrue(Double.isNaN(fraction.decimal()));
    }

    @Test
    public void testToString() {
        Fraction fraction = new Fraction(4, 5);
        Assertions.assertEquals("Fraction{numerator=4, denominator=5}", fraction.toString());
    }
}

package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FractionTest {

    @Test
    void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        Assertions.assertEquals(1, fraction.getNumerator());
        Assertions.assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(2, 3);
        Assertions.assertEquals((double) 2 / 3, fraction.decimal(), 1e-5);
        fraction.setDenominator(0);
        Assertions.assertTrue(Double.isInfinite(fraction.decimal()));
        fraction.setNumerator(0);
        Assertions.assertTrue(Double.isNaN(fraction.decimal()));
    }

    @Test
    void testIsProper() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(5, 4);
        Fraction fraction3 = new Fraction();
        Assertions.assertTrue(fraction1.isProper());
        Assertions.assertFalse(fraction2.isProper());
        Assertions.assertFalse(fraction3.isProper());
    }

    @Test
    void testIsImproper() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(5, 4);
        Fraction fraction3 = new Fraction();
        Assertions.assertFalse(fraction1.isImproper());
        Assertions.assertTrue(fraction2.isImproper());
        Assertions.assertFalse(fraction3.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(5, 4);
        Fraction fraction3 = new Fraction(10, 15);
        Assertions.assertFalse(fraction1.isEquivalent(fraction2));
        Assertions.assertTrue(fraction1.isEquivalent(fraction3));
    }

    @Test
    void testAdd() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(5, 4);
        Fraction fraction3 = new Fraction(1, 1);
        fraction1.add(fraction2);
        Assertions.assertEquals((2.0 / 3.0 + 5.0 / 4.0), fraction1.decimal(), 1e-5);
        fraction3.add(fraction1);
        Assertions.assertEquals(fraction3.decimal(), fraction1.decimal() + 1.0, 1e-5);
    }

    @Test
    void testMultiply() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(5, 4);
        Fraction fraction3 = new Fraction();
        fraction1.multiply(fraction2);
        Assertions.assertEquals((2.0 / 3.0) * (5.0 / 4.0), fraction1.decimal(), 1e-5);
        fraction3.multiply(fraction1);
        Assertions.assertEquals(fraction3.decimal(), fraction1.decimal(), 1e-5);
    }

    @Test
    void testDivide() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(5, 4);
        Fraction fraction3 = new Fraction();
        fraction1.divide(fraction2);
        Assertions.assertEquals((2.0 / 3.0) / (5.0 / 4.0), fraction1.decimal(), 1e-5);
        fraction3.divide(fraction1);
        Assertions.assertEquals(fraction3.decimal(), 1.0 / fraction1.decimal(), 1e-5);
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(4, 5);
        Assertions.assertEquals("Fraction{numerator=4, denominator=5}", fraction.toString());
    }
}

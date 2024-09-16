package es.upm.miw.iwvg_devops.code;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Creates a Fraction with the value 1.0 (1/1)
     */
    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Return the value of the function as a floating point number
     * @return Result of dividing the numerator by the denominator
     */
    public double decimal() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return "Fraction{numerator=" + numerator + ", denominator=" + denominator + "}";
    }
}

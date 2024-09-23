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
     * Indicates if the fraction is proper
     *
     * @return true if the numerator is <strong>smaller</strong> than the denominator and false otherwise
     */
    public boolean isProper() {
        return numerator < denominator;
    }

    /**
     * Indicates if the fraction is improper
     *
     * @return true if the numerator is <strong>greater</strong> than the denominator and false otherwise
     */
    public boolean isImproper() {
        return numerator > denominator;
    }

    /**
     * Indicates if the parameter fraction has the same value
     *
     * @param other Fraction to be compared with
     * @return true if fractions represent the same number and false otherwise
     */
    public boolean isEquivalent(Fraction other) {
        Fraction clone = clone();
        clone.subtract(other);
        return clone.numerator == 0;
    }

    /**
     * Adds another fraction value
     *
     * @param other Fraction to be added
     */
    public void add(Fraction other) {
        int denominatorsLCM = leastCommonMultiple(denominator, other.denominator);
        setNumerator(numerator * (denominatorsLCM / denominator) + other.numerator * (denominatorsLCM / other.denominator));
        setDenominator(denominatorsLCM);
    }

    /**
     * Subtract another fraction value
     *
     * @param other Fraction to be subtracted
     */
    public void subtract(Fraction other) {
        //Subtracting by adding with opposite sign
        numerator *= -1;
        add(other);
    }

    /**
     * Multiply another fraction to this
     *
     * @param other Fraction to be multiplied with
     */
    public void multiply(Fraction other) {
        setNumerator(numerator * other.numerator);
        setDenominator(denominator * other.denominator);
    }

    /**
     * Divide by argument fraction
     *
     * @param divisor Fraction
     */
    public void divide(Fraction divisor) {
        setNumerator(numerator * divisor.denominator);
        setDenominator(denominator * divisor.numerator);
    }

    /**
     * Return the value of the function as a floating point number
     *
     * @return Result of dividing the numerator by the denominator
     */
    public double decimal() {
        return (double) numerator / denominator;
    }

    /**
     * Calculates the GCD of two integers
     *
     * @param a first number
     * @param b second number
     * @return GCD of a and b
     */
    private int greatestCommonDivisor(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b; // % is remainder
            a = tmp;
        }
        return a;
    }

    /**
     * Calculates the LCM of two integers
     *
     * @param a first number
     * @param b second number
     * @return LCM of a and b
     */
    private int leastCommonMultiple(int a, int b) {
        return a * (b / greatestCommonDivisor(a, b));
    }

    /**
     * Creates a new instance of Fraction preserving its value
     * @return Fraction cloned instance
     */
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public Fraction clone() {
        return new Fraction(numerator, denominator);
    }

    @Override
    public String toString() {
        return "Fraction{numerator=" + numerator + ", denominator=" + denominator + "}";
    }
}

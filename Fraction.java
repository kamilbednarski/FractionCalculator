public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction toLowestTerms() {
        int a = numerator;
        int b = denominator;
        while (a != 0 && b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        this.numerator = this.numerator/a;
        this.denominator = this.denominator/a;

        return new Fraction(this.numerator, this.denominator);

    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction multiply(Fraction whichFraction) {
        int a = whichFraction.numerator * numerator;
        int b = whichFraction.denominator * denominator;
        return new Fraction(a, b);
    }

    public Fraction divide(Fraction whichFraction) {
        int a = numerator * whichFraction.denominator;
        int b = denominator * whichFraction.numerator;
        return new Fraction(a, b);
    }

    public Fraction add(Fraction whichFraction) {
        int a = whichFraction.numerator * denominator + numerator*whichFraction.denominator;
        int b = whichFraction.denominator * denominator;
        return new Fraction(a, b);
    }

    public Fraction subtract(Fraction whichFraction) {
        int a = whichFraction.numerator * denominator - numerator * whichFraction.denominator;
        int b = denominator * whichFraction.denominator;
        return new Fraction(a, b);
    }

    public double toDouble() {
        return (double)this.numerator / this.denominator;
    }

    @Override
    public String toString() {
        return "Fraction{" + "numerator=" + numerator + ", denominator=" + denominator + '}';
    }
}

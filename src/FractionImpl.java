package fraction;

import java.lang.ArithmeticException;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;

    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    public FractionImpl(int numerator, int denominator) {
        if(denominator == 0){
            throw new ArithmeticException("Divide by zero");
        }else if (numerator == 0){
            this.numerator = 0;
            this.denominator = 1;
            return;
        } else{
            int[] numDen = reducedForm(numerator, denominator);

            this.numerator = numDen[0];
            this.denominator = numDen[1];
        }
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {

        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {

        String[] fractArray = fraction.trim().split("/");

        if(fractArray.length == 1){
            this.numerator = Integer.parseInt(fractArray[0].trim());
            this.denominator = 1;
        } else if (fractArray.length == 2) {
            int numerator = Integer.parseInt(fractArray[0].trim());
            int denominator = Integer.parseInt(fractArray[1].trim());

            if(denominator == 0){
                throw new ArithmeticException("Denominator can't be equal to zero");
            }
            if(numerator == 0){
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            int [] numDen= reducedForm(numerator, denominator);
            this.numerator = numDen[0];
            this.denominator = numDen[1];
        } else{
            //If the array has a length equal to zero or bigger than 2, it throws the NumberFormatException
            throw new NumberFormatException("Malformed input");
        }
    }

    /**
     * Helper to reduce the fraction form, finding the greatest common divisor and returning the new numbers.
     * Two integers arguments are needed, and they must be given in the correct order - numerator, and denominator.
     *
     * @param numerator
     * @param denominator
     * @return an array with 2 elements, the reduced numerator and denominator in this respective order
     */
    private static int[] reducedForm(int numerator, int denominator){
        boolean isNumNegative = numerator < 0;
        boolean isDenNegative = denominator < 0;

        int aPos = Math.abs(numerator);
        int bPos = Math.abs(denominator);
        int[] result = new int[2];

//        It gets the minimum number (between numerator and denominator) and from this min number it goes to the
//        loop and stops as soon it finds the first (and bigger) divisor where the numerator and denominator
//        modules are equal to 0 and returns it new values:
//        - numerator/divisor
//        - denominator/divisor
        for (int i = Math.min(aPos, bPos) ; i > 0 ; i--) {
            if (aPos % i == 0 && bPos % i == 0){
                aPos = aPos/i;
                bPos = bPos/i;

                if (isDenNegative && !isNumNegative || !isDenNegative && isNumNegative ){
                    result[0] = aPos*(-1);
                } else {
                    result[0] = aPos;
                }
                result[1] = bPos;
            }
        }
        return result;
    }

    /**
     * @inheritDoc
     */

    @Override
    public Fraction add(Fraction f) {
        FractionImpl frac = new FractionImpl(String.valueOf(f));
        int fracNum = frac.numerator;
        int fracDen = frac.denominator;

        int sumNumerator = (this.numerator * fracDen) + (fracNum * this.denominator);
        int sumDenominator = this.denominator*fracDen;
        return new FractionImpl(sumNumerator, sumDenominator);
    }

    /**
     * @inheritDoc
     */

    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl frac = new FractionImpl(String.valueOf(f));
        int fracNum = frac.numerator;
        int fracDen = frac.denominator;

        int subNumerator = (this.numerator * fracDen) - (fracNum * this.denominator);
        int subDenominator = this.denominator*fracDen;
        return new FractionImpl(subNumerator, subDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl frac = new FractionImpl(String.valueOf(f));
        int fracNum = frac.numerator;
        int fracDen = frac.denominator;

        int multNumerator = (this.numerator * fracNum);
        int multDenominator = this.denominator*fracDen;
        return new FractionImpl(multNumerator, multDenominator);
    }

    /**
     * @inheritDoc
     */

    @Override
    public Fraction divide(Fraction f) {
        FractionImpl frac = new FractionImpl(String.valueOf(f));
        int fracNum = frac.numerator;
        int fracDen = frac.denominator;

        int divNumerator = this.numerator * fracDen;
        int divDenominator = fracNum * this.denominator;
        return new FractionImpl(divNumerator, divDenominator);
    }

    /**
     * @inheritDoc
     */

    @Override
    public Fraction abs() {
        return new FractionImpl(Math.abs(this.numerator), Math.abs(this.denominator));
    }

    /**
     * @inheritDoc
     */

    @Override
    public Fraction negate() {
        return new FractionImpl((-1*(this.numerator)), this.denominator);
    }

    /**
     * @inheritDoc
     */

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */

    @Override
    public boolean equals (Object obj) {
        if (obj instanceof FractionImpl) {
            FractionImpl frac = (FractionImpl) obj; // converts the obj to a new FractionImpl
            int fracNum = frac.numerator;
            int fracDen = frac.denominator;

            boolean isEqual = this.numerator == fracNum && this.denominator == fracDen;
            return isEqual;
        } else {
            return false;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
//    This method inverts the position of the instances of FractionImpl, returning it as a new fraction.
    @Override
    public Fraction inverse() {
        if(this.numerator < 0){
            return new FractionImpl((-1 * this.denominator), (-1 * this.numerator));
        }
        return new FractionImpl(this.denominator, this.numerator);
    }

    /**
     * @inheritDoc
     */

    @Override
    public int compareTo(Fraction o) {
        FractionImpl frac = new FractionImpl(String.valueOf(o));
        int fracNum = frac.numerator;
        int fracDen = frac.denominator;

        double elem1;
        double elem2;

        elem1 = (double)(int) this.numerator/this.denominator;
        elem2 = (double)(int) fracNum/fracDen;

        if(elem1 > elem2){
            return 1;
        } else if(elem1 < elem2){
            return -1;
        }
        return 0;
    }

    /**
     * @inheritDoc
     */

    @Override
    public String toString() {
        if(this.denominator == 1){
            return Integer.toString(this.numerator);
        }
        return this.numerator + "/" + this.denominator;
    }
}

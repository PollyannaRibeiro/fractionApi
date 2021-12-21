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

    int numerator;
    int denominator;
    boolean isDenNegative;
    boolean isNumNegative;

    public FractionImpl(int numerator, int denominator) {
        // TODO
        this.numerator = numerator;
        this.denominator = denominator;
        isDenNegative = false;

        if(this.denominator == 0){
            throw new ArithmeticException("Denominator can't be equal to zero");
        } else if(this.denominator < 0){
            this.denominator = Math.abs(this.denominator);
            isDenNegative = true;
        }
        if (this.numerator < 0){
            this.numerator = Math.abs(this.numerator);
            isNumNegative = true;
        }

        for (int i = Math.min(this.numerator, this.denominator); i > 0 ; i--) {
            if (this.numerator % i == 0 && this.denominator % i == 0){
                this.numerator = this.numerator/i;
                this.denominator = this.denominator/i;
                return;
            }
        }

        if (isDenNegative && !isNumNegative || !isDenNegative && isNumNegative ){
                this.numerator *= -1;
        }
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        // TODO
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

    private int NumFromString(String a){

        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
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
    public boolean equals(Object obj) {
        return super.equals(obj);
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
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return null;
    }

    public static void main(String[] args) {
//        FractionImpl f = new FractionImpl("  10 //4");
//        System.out.println(f);
//        FractionImpl f2 = new FractionImpl("  1 0 /4");
//        System.out.println(f2);
        FractionImpl f3 = new FractionImpl("  10 / -4");
        System.out.println(f3);
        FractionImpl f4 = new FractionImpl("  -10 / -4");
        System.out.println(f4);
    }
}
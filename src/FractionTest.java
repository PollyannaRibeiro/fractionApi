// 13725220
// palbuq01@student.bbk.ac.uk

package fraction;

import org.junit.*;
import static org.junit.Assert.*;

public class FractionTest {
    /**
     * testing all object creation options of this class and its possible errors
     */

    @Test
    public void testFractionImplTwoInt (){
        FractionImpl f1 = new FractionImpl(9, 15);
        assertEquals(f1.toString(), "3/5");

        FractionImpl f2 = new FractionImpl(-3, 5);
        assertEquals(f2.toString(), "-3/5");
    }

    @Test(expected = ArithmeticException.class)
    public void testFractionImplDenominatorZeroError(){
        FractionImpl f5 = new FractionImpl(-3, 0);
    }

    @Test
    public void testNegativeNominatorDenominatorBehaviour(){
        FractionImpl f1 = new FractionImpl(3, -5);
        assertEquals(f1.toString(), "-3/5");

        FractionImpl f2 = new FractionImpl(-3);
        assertEquals(f2.toString(), "-3");

        FractionImpl f3 = new FractionImpl(-3, -7);
        assertEquals(f3.toString(), "3/7");
    }

    @Test
    public void testFractionImplWholeNumber (){
        FractionImpl f1 = new FractionImpl(3);
        assertEquals(f1.toString(), "3");

        FractionImpl f2 = new FractionImpl(1547);
        assertEquals(f2.toString(), "1547");
    }

    @Test
    public void testZeroNominatorRepresentation() {
        FractionImpl f1 = new FractionImpl(0);
        assertEquals(f1.toString(), "0");

        FractionImpl f2 = new FractionImpl(0, 5);
        assertEquals(f2.toString(), "0");

        FractionImpl f3 = new FractionImpl("0/3");
        assertEquals(f3.toString(), "0");
    }

    @Test
    public void testFractionImplString (){
        FractionImpl f1 = new FractionImpl("9 / 15");
        assertEquals(f1.toString(), "3/5");

        FractionImpl f2 = new FractionImpl("    -3     /   5   ");
        assertEquals(f2.toString(), "-3/5");

        FractionImpl f3 = new FractionImpl(" -10 /      -50             ");
        assertEquals(f3.toString(), "1/5");

        FractionImpl f4 = new FractionImpl(" 11 ");
        assertEquals(f4.toString(), "11");

        FractionImpl f5 = new FractionImpl(" 22 /   ");
        assertEquals(f5.toString(), "22");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplStringError (){
        FractionImpl f1 = new FractionImpl("9 // 15");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplStringError2 (){
        FractionImpl f2 = new FractionImpl(" -3 7   /   5   ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplStringError3 (){
        FractionImpl f3 = new FractionImpl("- 37 /-5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplStringError4 (){
        FractionImpl f4 = new FractionImpl(" -10 20/  3");
    }

    @Test(expected = ArithmeticException.class)
    public void testFractionImplStringError5 (){
        FractionImpl f5 = new FractionImpl(" -10 / 0");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplStringError6 (){
        FractionImpl f6 = new FractionImpl(" -1 0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplStringError7 (){
        FractionImpl f7 = new FractionImpl(" Hi ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplStringError8 (){
        FractionImpl f8 = new FractionImpl("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplStringError9 (){
        FractionImpl f9 = new FractionImpl("   ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplStringError10 (){
        FractionImpl f10 = new FractionImpl(" 25/12/21  ");
    }
    /**
     * testing the helper
     */

    @Test
    public void testReduceForm() {

        FractionImpl f1 = new FractionImpl(10, 50);
        assertEquals(f1.toString(), "1/5");

        FractionImpl f2 = new FractionImpl(-12, 6);
        assertEquals(f2.toString(), "-2");

        FractionImpl f3 = new FractionImpl(7, 3);
        assertEquals(f3.toString(), "7/3");
    }

    /**
     * testing all the methods and possible errors
     */

    @Test
    public void testFractionImplAddMethod(){
        FractionImpl f1 = new FractionImpl("2 / 3");
        FractionImpl f1_1 = new FractionImpl("4 / 5");
        FractionImpl newFraction = (FractionImpl) f1.add(f1_1);
        assertEquals(newFraction.toString(), "22/15");

        FractionImpl f2 = new FractionImpl(1, 3);
        FractionImpl f2_1 = new FractionImpl("1 / 5");
        FractionImpl newFraction2 = (FractionImpl) f2.add(f2_1);
        assertEquals(newFraction2.toString(), "8/15");

        FractionImpl f3 = new FractionImpl(4);
        FractionImpl f3_1 = new FractionImpl("1 / -5");
        FractionImpl newFraction3 = (FractionImpl) f3.add(f3_1);
        assertEquals(newFraction3.toString(), "19/5");

        FractionImpl f4 = new FractionImpl(-4);
        FractionImpl f4_1 = new FractionImpl(1, 5);
        FractionImpl newFraction4 = (FractionImpl) f4.add(f4_1);
        assertEquals(newFraction4.toString(), "-19/5");
    }

    @Test
    public void testFractionImplSubtractMethod(){
        FractionImpl f1 = new FractionImpl("2 / 3");
        FractionImpl f1_1 = new FractionImpl("  4 / 17  ");
        FractionImpl newFraction = (FractionImpl) f1.subtract(f1_1);
        assertEquals(newFraction.toString(), "22/51");

        FractionImpl f2 = new FractionImpl(-4);
        FractionImpl f2_1 = new FractionImpl("1 / 5");
        FractionImpl newFraction2 = (FractionImpl) f2.subtract(f2_1);
        assertEquals(newFraction2.toString(), "-21/5");

        FractionImpl f3 = new FractionImpl(4);
        FractionImpl f3_1 = new FractionImpl(1, -5);
        FractionImpl newFraction3 = (FractionImpl) f3.subtract(f3_1);
        assertEquals(newFraction3.toString(), "21/5");
    }

    @Test
    public void testFractionImplMultiplyMethod(){
        FractionImpl f1 = new FractionImpl(17, 5);
        FractionImpl f1_1 = new FractionImpl(" -6 / 8");
        FractionImpl newFraction = (FractionImpl) f1.multiply(f1_1);
        assertEquals(newFraction.toString(), "-51/20");

        FractionImpl f2 = new FractionImpl(2, 5);
        FractionImpl f2_1 = new FractionImpl("5");
        FractionImpl newFraction2 = (FractionImpl) f2.multiply(f2_1);
        assertEquals(newFraction2.toString(), "2");

        FractionImpl f3 = new FractionImpl(4);
        FractionImpl f3_1 = new FractionImpl("1 / -5");
        FractionImpl newFraction3 = (FractionImpl) f3.multiply(f3_1);
        assertEquals(newFraction3.toString(), "-4/5");
    }

    @Test
    public void testFractionImplDivideMethod(){
        FractionImpl f1 = new FractionImpl(2, 5);
        FractionImpl f1_1 = new FractionImpl(" 5 ");
        FractionImpl newFraction = (FractionImpl) f1.divide(f1_1);
        assertEquals(newFraction.toString(), "2/25");

        FractionImpl f2 = new FractionImpl(8);
        FractionImpl f2_1 = new FractionImpl(4, 3);
        FractionImpl newFraction2 = (FractionImpl) f2.divide(f2_1);
        assertEquals(newFraction2.toString(), "6");
    }

    @Test
    public void testFractionImplAbsMethod(){
        FractionImpl f1 = new FractionImpl(-2, 3);
        FractionImpl newFraction1 = (FractionImpl) f1.abs();
        assertEquals(newFraction1.toString(), "2/3");

        FractionImpl f2 = new FractionImpl(2, -3);
        FractionImpl newFraction2 = (FractionImpl) f2.abs();
        assertEquals(newFraction2.toString(), "2/3");

        FractionImpl f3 = new FractionImpl(-2, -8);
        FractionImpl newFraction3 = (FractionImpl) f3.abs();
        assertEquals(newFraction3.toString(), "1/4");
    }

    @Test
    public void testFractionImplNegateMethod(){
        FractionImpl f1 = new FractionImpl(-2, 3);
        FractionImpl newFraction1 = (FractionImpl) f1.negate();
        assertEquals(newFraction1.toString(), "2/3");

        FractionImpl f2 = new FractionImpl("2 / 3");
        FractionImpl newFraction2 = (FractionImpl) f2.negate();
        assertEquals(newFraction2.toString(), "-2/3");

        FractionImpl f3 = new FractionImpl(-4, -5);
        FractionImpl newFraction3 = (FractionImpl) f3.negate();
        assertEquals(newFraction3.toString(), "-4/5");
    }

    @Test
    public void testFractionImplEqual(){
        FractionImpl f1 = new FractionImpl(-2, 3);
        FractionImpl f1_1 = new FractionImpl(2, -3);
        boolean result1 = f1.equals(f1_1);
        assertTrue(result1);

        FractionImpl f2 = new FractionImpl(1, 4);
        FractionImpl f2_1 = new FractionImpl("2 / 8   ");
        boolean result2 = f2.equals((f2_1));
        assertTrue(result2);

        Integer[] obj = {1, 2, 3};
        FractionImpl f = new FractionImpl(3);
        assertFalse(f.equals(obj));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFractionImplEqualError1(){
        FractionImpl f1 = new FractionImpl(-2, 3);
        boolean result1 = f1.equals(new FractionImpl(" - 2/  3"));
        assertTrue(result1);
    }

    @Test(expected = ArithmeticException.class)
    public void testFractionImplEqualError2(){
        FractionImpl f1 = new FractionImpl(1, 4);
        boolean result1 = f1.equals((new FractionImpl("2 / 0   ")));
        assertTrue(result1);
    }

    @Test
    public void testFractionImplInverse(){
        FractionImpl f1 = new FractionImpl(3, -5);
        FractionImpl f1_1 = new FractionImpl(String.valueOf(f1.inverse()));
        assertEquals(f1_1.toString(), "-5/3");

        FractionImpl f2 = new FractionImpl(-3);
        FractionImpl f2_1 = new FractionImpl(String.valueOf(f2.inverse()));
        assertEquals(f2_1.toString(), "-1/3");

        FractionImpl f3 = new FractionImpl("3/7");
        FractionImpl f3_1 = new FractionImpl(String.valueOf(f3.inverse()));
        assertEquals(f3_1.toString(), "7/3");

    }

    @Test
    public void testFractionImplCompareTo(){
        FractionImpl f1 = new FractionImpl(-2, 3);
        FractionImpl f1_1 = new FractionImpl(2, -3);
        int result1 = f1.compareTo(f1_1);
        assertTrue(result1 == 0);

        FractionImpl f2 = new FractionImpl(1, 4);
        FractionImpl f2_1 = new FractionImpl("2 / 7   ");
        int result2 = f2.compareTo(f2_1);
        assertTrue(result2 == -1);

        FractionImpl f3 = new FractionImpl(5);
        FractionImpl f3_1 = new FractionImpl(31, 7);
        int result3 = f3.compareTo(f3_1);
        assertTrue(result3 == 1);
    }

    @Test
    public void testFractionImplToString(){
        FractionImpl f1 = new FractionImpl(9, 15);
        String str1 = f1.toString();
        assertEquals(str1,"3/5" );

        FractionImpl f2 = new FractionImpl(-3, 5);
        String str2 = f2.toString();
        assertEquals(str2,"-3/5" );

        FractionImpl f3 = new FractionImpl(-5);
        String str3 = f3.toString();
        assertEquals(str3,"-5" );

        FractionImpl f4 = new FractionImpl(" 15 /   30");
        String str4 = f4.toString();
        assertEquals(str4,"1/2" );
    }
}


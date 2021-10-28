package funcs.math;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//My Mathematical supporting functions
public class MathFuncs {
    List<Integer> a = new ArrayList<>();

    public long factorial(long number) {
        if (number == 0) {
            return 1;
        } else {
            long ansFactorial = (number*factorial(number-1));
            return ansFactorial;
        }
    }
    public long power(long base, long exp) {
        if (exp == 0) {
            return 1;
        } else {
            long ansPower = base;
            for (long i = 1; i < exp; i++) {
                ansPower = ansPower*base;
            }
            return ansPower;
        }
    }
    public String bigFactorial(String number) {
        if (number.equals("0")) {
            return "1";
        } else {
            BigInteger bigNumber = new BigInteger(number);
            BigInteger bigAnsFactorial = new BigInteger("0");
            bigAnsFactorial = bigNumber.multiply(
                new BigInteger(bigFactorial(String.valueOf(bigNumber.subtract(new BigInteger("1"))))));
            return String.valueOf(bigAnsFactorial);
        }
    }
    public String bigPower(String base, String exp) {
        BigInteger bigBase = new BigInteger(base);
        BigInteger bigAnsPower = new BigInteger(base);
        for (long i = 1; i < Long.parseLong(exp); i++) {
            bigAnsPower = bigAnsPower.multiply(bigBase);
        }
        return String.valueOf(bigAnsPower);
    }
    public long ellipseIntegralFunc(List<Integer> semiax, int i, int dimMax, boolean starter) {
        long ellipseIntegralFuncAns = 0;
        if (i != dimMax) {
            if (starter==true) {
                a = semiax;
                System.out.println(a);
                ellipseIntegralFunc(a, i, dimMax, false);
            } else {
                ellipseIntegralFuncAns = a.get((i-1));
            }
        }
        


        return ellipseIntegralFuncAns;
    }
}

package funcs.math;
import java.math.BigDecimal;
import java.math.BigInteger;

//My Mathematical supporting functions
public class MathFuncs {
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
    public BigDecimal gammaFunction(String number) {
        BigDecimal gammaFunctionAns = new BigDecimal("0");
        BigDecimal inf = new BigDecimal((String.valueOf(Long.MAX_VALUE)));
        inf = inf.multiply(inf);
        BigDecimal zero = new BigDecimal("0");
        BigDecimal n = new BigDecimal("65536");
        System.out.println("Inf: "+String.valueOf(inf));
        // gammaFunctionAns = (inf.divide(n)).multiply(());
        return gammaFunctionAns;
    }
    private BigDecimal gammaFunctionSum(String number, String n) {
        BigDecimal gammaFunctionSumAns = new BigDecimal("0");
        return gammaFunctionSumAns;
    }
    private BigDecimal gammaFunctionInnerFunc(String x, String z) {
        BigDecimal gammaFuBigDecimalAns = new BigDecimal("0");
        return gammaFuBigDecimalAns;
    }
}

package funcs.math;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//My Mathematical supporting functions
public class MathFuncs {
    // Constants
    public double e =  2.71828182845904523536028747135266249775724709369995;
    public double pi = 3.14159265358979323846264338327950288419716939937510;
    public long inf = Long.MAX_VALUE;
    // Functions
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
    public double gammaFunc(double number) {
        double ans = 0;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "python", System.getProperty("user.dir") + "\\lib\\python\\math\\SympymathFuncs.py",
                String.valueOf("gammaFunc"), String.valueOf(number)
            );
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                ans = Double.parseDouble(reader.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }
}

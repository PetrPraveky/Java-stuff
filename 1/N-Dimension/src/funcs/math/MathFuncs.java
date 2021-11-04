package funcs.math;
import java.math.BigInteger;

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
    public void gammaFunc() {

    }
}

// //Python Interpreter
// class PythonInt {
//     PythonInterpreter python = null;

//     public PythonInt()  {
//         Properties properties = new Properties();
//         properties.setProperty("python.path", "../lib/python/math");
//         PythonInterpreter.initialize(System.getProperties(), properties, new String[0]);
//         this.python = new PythonInterpreter();
//     }

//     public void execfile(final String fileName) {
//         this.python.execfile(fileName);
//     }
//     public PyInstance createClass(final String className, final String opts) {
//         return (PyInstance) this.python.eval(className+"("+opts+")");
//     }
// }
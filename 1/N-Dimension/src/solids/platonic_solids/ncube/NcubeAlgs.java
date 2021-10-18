package solids.platonic_solids.ncube;

import funcs.math.*;
import java.math.BigInteger;

public class NcubeAlgs {
    // Function for counting vertices in higher dimensions
    public String vertices(String dimension) {
        String a = "2";
        MathFuncs mfunc = new MathFuncs();
        if (dimension.equals("0")) {
            return "1";
        } else {            
            String ansVerticesCount = mfunc.bigPower(a, dimension); 
            return ansVerticesCount;
        }
    }
    // Function for counting edges in higher dimensions
    public String edges(String dimension) {
        String a = dimension; String b = (String.valueOf((Integer.parseInt(dimension)-1)));
        MathFuncs mfunc = new MathFuncs();
        BigInteger bigA = new BigInteger(a); BigInteger ansEdgeCount = new BigInteger("0");
        if (dimension.equals("1")) {
            return "1";
        } else {
            ansEdgeCount = (bigA.multiply(new BigInteger(mfunc.bigPower("2", b))));
            return String.valueOf(ansEdgeCount);
        }
    }
    // Function for counting 2D faces in higher dimensions
    public String faces(String dimension) {
        MathFuncs mfunc = new MathFuncs();
        if (dimension.equals("0") || dimension.equals("1")) {
            return "0";
        } else if (dimension.equals("2")) {
            return "1";
        } else {
            String a = "2"; String b = dimension;
            BigInteger bigA = new BigInteger("2"); BigInteger bigB = new BigInteger(b);
            BigInteger bigAnsFacesCount = new BigInteger("0");
            bigAnsFacesCount = (new BigInteger(mfunc.bigPower("2", String.valueOf(bigB.subtract(bigA))))).multiply((new BigInteger(mfunc.bigFactorial(b))).divide((new BigInteger(mfunc.bigFactorial(a))).multiply(new BigInteger(mfunc.bigFactorial(String.valueOf(bigB.subtract(bigA)))))));
            return String.valueOf(bigAnsFacesCount);
        }
    }
    // Function for counting 3D cells in higher dimensions
    public String cells(String dimension) {
        MathFuncs mfunc = new MathFuncs();
        if (dimension.equals("0") || dimension.equals("1") || dimension.equals("2")) {
            return "0";
        } else if (dimension.equals("3")) {
            return "1";
        } else {
            String a = "3"; String b = dimension;
            BigInteger bigA = new BigInteger("3"); BigInteger bigB = new BigInteger(b);
            BigInteger bigAnsFacesCount = new BigInteger("0");
            bigAnsFacesCount = (new BigInteger(mfunc.bigPower("2", String.valueOf(bigB.subtract(bigA))))).multiply((new BigInteger(mfunc.bigFactorial(b))).divide((new BigInteger(mfunc.bigFactorial(a))).multiply(new BigInteger(mfunc.bigFactorial(String.valueOf(bigB.subtract(bigA)))))));
            return String.valueOf(bigAnsFacesCount);
        }
    }
    // Default function for count of n-1 dimensional objects
    public String cellAlgDef(String dimension) {
        MathFuncs mfunc = new MathFuncs();
        String a = String.valueOf(Integer.valueOf(dimension)-1); String b = dimension;
        BigInteger bigA = new BigInteger(String.valueOf(Integer.valueOf(dimension)-1)); BigInteger bigB = new BigInteger(b);
        BigInteger bigAnsCellAlgDef = new BigInteger("0");
        bigAnsCellAlgDef = (new BigInteger(mfunc.bigPower("2", String.valueOf(bigB.subtract(bigA))))).multiply((new BigInteger(mfunc.bigFactorial(b))).divide((new BigInteger(mfunc.bigFactorial(a))).multiply(new BigInteger(mfunc.bigFactorial(String.valueOf(bigB.subtract(bigA)))))));
        return String.valueOf(bigAnsCellAlgDef);
    }
}

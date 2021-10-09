package funcs.platonic_solids;
import java.math.BigInteger;
import funcs.math.MathFuncs;
// Class for hypercubes in n-dimensions
public class Ncube {
    public Ncube(int dimension) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Vertices, edges, faces and cells count for "+dimension+"-D cube:");
        System.out.println("- Vertices count:    "+vertices(Integer.toString(dimension)));
        System.out.println("- Edges count:       "+edges(Integer.toString(dimension)));
        System.out.println("- Faces count:       "+faces(Integer.toString(dimension)));
        System.out.println("- Cells (3D) count:  "+cells(Integer.toString(dimension)));
        System.out.println("Shape values for "+dimension+"-D cube");
        System.out.println("- Volume:            a^"+dimension);
        System.out.println("- Surface area (2D): "+faces(Integer.toString(dimension))+"a^2");
        // System.out.println("test - ");
    }
    // Function for counting vertices in higher dimensions
    private String vertices(String dimension) {
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
    private String edges(String dimension) {
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
    private String cells(String dimension) {
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
}
package funcs;
import java.math.BigInteger;
import funcs.math.MathFuncs;
// Function for rectangles in 4D
public class Nrectangle {
    public Nrectangle(int dimension) {
        	new Ncube(dimension);
    }
}
class Ncube {
    public Ncube(int dimension) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Corner, edge, face and cell count for "+dimension+"-D cube:");
        System.out.println("- Corner count:      "+corners(dimension));
        System.out.println("- Edge count:        "+edges(dimension));
        if (dimension < 21) {
            System.out.println("- Face count:        "+faces(dimension));
            System.out.println("- Cell (3D) count:   "+cells(dimension));
        } else {
            System.out.println("- Face count:        "+bigFaces(Integer.toString(dimension)));
            System.out.println("- Cell (3D) count:   "+bigCells(Integer.toString(dimension)));
        }
        System.out.println("Shape values for "+dimension+"-D cube");
        System.out.println("- Volume:            a^"+dimension);
        if (dimension < 21) {
            System.out.println("- Surface area (2D): "+faces(dimension)+"a^2");
        }
        else {
            System.out.println("- Surface area (2D): "+bigFaces(Integer.toString(dimension))+"a^2");
        }
    }
        // Function for counting corners in higher dimensions
    private long corners(int dimension) {
        long a = 2; long b = dimension;
        MathFuncs mfunc = new MathFuncs();
        long ansCornerCount = mfunc.power(a, b); 
        return ansCornerCount;
    }
    // Function for counting edges in higher dimensions
    private long edges(int dimension) {
        long a = dimension; long b = (dimension-1);
        MathFuncs mfunc = new MathFuncs();
        long ansEdgeCount = (a*mfunc.power(2, b));
        return ansEdgeCount;
    }
    // Function for counting 2D faces in higher dimensions
    private long faces(int dimension) {
        MathFuncs mfunc = new MathFuncs();
        if (dimension > 1) {
            long a = 2; long b = dimension;
            long ansFacesCount = mfunc.power(2, (b-a))*(mfunc.factorial(b)/(mfunc.factorial(a)*mfunc.factorial((b-a))));
            return ansFacesCount;
        } else {
            return 0;
        }
    }
    // Function for counting 3D cells in higher dimensions
    private long cells(int dimension) {   
        MathFuncs mfunc = new MathFuncs();
        if (dimension > 2) {
            long a = 3; long b = dimension;
            long ansCellsCount = mfunc.power(2, (b-a))*(mfunc.factorial(b)/(mfunc.factorial(a)*mfunc.factorial((b-a))));
            return ansCellsCount;
        } else {
            return 0;
        }
    }
    // Function for counting 2D faces in much higher dimensions
    public String bigFaces(String dimension) {
        MathFuncs mfunc = new MathFuncs();
        String a = "2"; String b = dimension;
        BigInteger bigA = new BigInteger("2"); BigInteger bigB = new BigInteger(b);
        BigInteger bigAnsFacesCount = new BigInteger("0");
        bigAnsFacesCount = (new BigInteger(mfunc.bigPower("2", String.valueOf(bigB.subtract(bigA))))).multiply((new BigInteger(mfunc.bigFactorial(b))).divide((new BigInteger(mfunc.bigFactorial(a))).multiply(new BigInteger(mfunc.bigFactorial(String.valueOf(bigB.subtract(bigA)))))));
        return String.valueOf(bigAnsFacesCount);
    }
    // Function for counting 3D cells in much higher dimensions
    public String bigCells(String dimension) {
        MathFuncs mfunc = new MathFuncs();
        String a = "3"; String b = dimension;
        BigInteger bigA = new BigInteger("3"); BigInteger bigB = new BigInteger(b);
        BigInteger bigAnsFacesCount = new BigInteger("0");
        bigAnsFacesCount = (new BigInteger(mfunc.bigPower("2", String.valueOf(bigB.subtract(bigA))))).multiply((new BigInteger(mfunc.bigFactorial(b))).divide((new BigInteger(mfunc.bigFactorial(a))).multiply(new BigInteger(mfunc.bigFactorial(String.valueOf(bigB.subtract(bigA)))))));
        return String.valueOf(bigAnsFacesCount);
    }
}
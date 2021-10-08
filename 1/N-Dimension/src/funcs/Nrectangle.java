package funcs;
import funcs.math.MathFuncs;
import java.lang.Math;
// Function for rectangles in 4D
public class Nrectangle {
    public Nrectangle(int dimension) {
        System.out.println("");
        System.out.println("Corner, edge, face and cell count for "+dimension+"-D hypercube");
        System.out.println("Corner count: "+corners(dimension));
        System.out.println("Edge count: "+edges(dimension));
        System.out.println("Face count: "+faces(dimension));
        System.out.println("Cell (3D) count: "+cells(dimension));
    }
    private int corners(int dimension) {
        double a = 2.0; double b = dimension;
        int ansCornerCount = (int) Math.pow(a, b); 
        return ansCornerCount;
    }
    private int edges(int dimension) {
        double a = dimension; double b = (dimension-1);
        int ansEdgeCount = (int) (a*Math.pow(2.0, b));
        return ansEdgeCount;
    }
    private int faces(int dimension) {
        if (dimension > 1) {
            double a = 2.0; double b = dimension;
            MathFuncs mfunc = new MathFuncs();
            int ansFacesCount = (int) (Math.pow(2.0, (b-a))*((double)(mfunc.factorial((long)b)/(mfunc.factorial((long)a)*mfunc.factorial(((long)(b-a)))))));
            return ansFacesCount;
        } else {
            return 0;
        }
    }
    private int cells(int dimension) {
        if (dimension > 2) {
            double a = 3.0; double b = dimension;
            MathFuncs mfunc = new MathFuncs();
            int ansFacesCount = (int) (Math.pow(2.0, (b-a))*((double)(mfunc.factorial((long)b)/(mfunc.factorial((long)a)*mfunc.factorial(((long)(b-a)))))));
            return ansFacesCount;
        } else {
            return 0;
        }        
    }
}

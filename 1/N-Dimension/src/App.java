import java.lang.Math;
// Program for computing stuff for higher dimensions
public class App {
    public static void main(String[] args) throws Exception {
        int dimNum = 10;
        new Nrectangle(dimNum);
    }
}
class Nrectangle {
    Nrectangle(int dimension) {
        System.out.println("Počet rohů: "+corners(dimension));
        System.out.println("Počet hran: "+edges(dimension));
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
}
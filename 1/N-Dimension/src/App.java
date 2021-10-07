import java.lang.Math;
// Program for computing stuff for higher dimensions
public class App {
    public static void main(String[] args) throws Exception {
        Nrectangle rectangle = new Nrectangle(4);
    }
}
class Nrectangle {
    int dimension;
    Nrectangle(int dimension) {
        this.dimension = dimension;
        System.out.println("Počet rohů: "+corners(dimension));
        System.out.println("Počet hran: "+edges(dimension));
    }
    private int corners(int dimension) {
        double a = 2.0; double b = dimension;
        int ansCornerCount = (int) Math.pow(a, b); 
        return ansCornerCount;
    };
    private int edges(int dimension) {
        return dimension;
    }
}
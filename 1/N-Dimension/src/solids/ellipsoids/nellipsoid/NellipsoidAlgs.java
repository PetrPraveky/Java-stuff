package solids.ellipsoids.nellipsoid;
import java.util.ArrayList;
import java.util.List;

import funcs.math.MathFuncs;

public class NellipsoidAlgs {
    List<Integer> a = new ArrayList<>();
    public long nEllipseSurfaceAlg(List<Integer> semiax, int dimension) {
        MathFuncs mathFuncs = new MathFuncs();
        long ellipseSurgaceAlgAns = 0;
        
        // if (i != (dimension-1)) {
        //     // if (starter==true) {
        //         // List<Integer> 
        //         // a = semiax;
        //         // System.out.println(a);
        //         // ellipseSurfaceAlg(a, i, dimMax, false);
        //     } else {
        //         ellipseSurgaceAlgAns = a.get((i-1));
        //     }
        // }
        // Integral calculation part

        // 2^n part
        ellipseSurgaceAlgAns = mathFuncs.power(2, dimension)*ellipseSurgaceAlgAns;
        return ellipseSurgaceAlgAns;
    }
    private long ellipseIntegralAlg(int i, int dimension) {
        long ellipseIntegralAlgAns = 0;

        if (i<dimension) {

        } else {

        }

        return ellipseIntegralAlgAns;
    }
    private long ellipseDeltaAlg(int am, int an) {
        long x = 
    }
}

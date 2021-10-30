package solids.ellipsoids.nellipsoid;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import funcs.math.MathFuncs;

public class NellipsoidAlgs {
    MathFuncs mathFuncs = new MathFuncs();
    public double nEllipseSurfaceAlg(int dimension) {
        List<Integer> a = new ArrayList<>();
        List<Double> x = new ArrayList<>();
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
        double ellipseSurfaceAlgAns = 0;
        int a1 = 2;
        for (int i = 0; i < dimension; i++) {
            a1 = a1+i;
            a.add(a1);
        }
        ellipseSurfaceAlgAns = ellipseIntegralAlg(a, x, dimension, 0, (-1), 0);
        ellipseSurfaceAlgAns = mathFuncs.power(2, dimension)*ellipseSurfaceAlgAns;
        return ellipseSurfaceAlgAns;
    }
    private double ellipseIntegralAlg(List<Integer> a, List<Double> x, int dimension, int coef, double x1, double up) {
        // int a = 0;
        // int n = 8;
        
        // if (i < dimension) {
            //     ellipseIntegralAlgAns = ((b-a)/8)*((ellipseIntegralAlg(i++, dimension, a)/2)+ellipseSum(dimension, n, a, b, i++)+(ellipseIntegralAlg(i++, dimension, b)/2));
            // } else {
                
        // }
        double ellipseIntegralAlgAns = 0;
        int n = 8;
        up = 1;
        if (x1 != (-1)) {
            x.add(x1);
        }
        if (coef != 0) {
            for (int i = 0; i < (dimension-2); i++) {
                up = up-(Math.pow(x.get((i-1)), 2)/Math.pow(a.get((i-1)), 2));
            }
            up = Math.sqrt(up);
        }
        if (coef < (dimension-1)) {
            ellipseIntegralAlgAns = (((a.get(coef)*up)-8)*((ellipseIntegralAlg(a, x, dimension, coef++, 0, up)/2)+));
        } else {
            ellipseIntegralAlgAns = ellipseEqAlg(a, x, dimension);
        }
        return ellipseIntegralAlgAns;
    }
    // Inner function for ellipse surface in dimension > 2
    private double ellipseEqAlg(List<Integer> a, List<Double> x, int dimension) {
        double ellipseEqAlgUpAns = 1;
        double ellipseEqAlgDownAns = 1;
        for (int i = 0; i < (dimension-1); i++) {
            ellipseEqAlgUpAns = ellipseEqAlgUpAns-((ellipseDeltaAlg(a.get((dimension-1)), a.get(i)))*(Math.pow(x.get(i), 2)/mathFuncs.power(a.get(i), 2)));
        }
        for (int j = 0; j < (dimension-1); j++) {
            ellipseEqAlgDownAns = ellipseEqAlgDownAns-((Math.pow(x.get(j), 2)/mathFuncs.power(a.get(j), 2)));
        }
        return Math.sqrt(ellipseEqAlgUpAns/ellipseEqAlgDownAns);
    }
    // Ellipse sum for ellipse Integral
    private double ellipseSum(List<Integer> a, List<Double> x, int n, int coef, int dimension, double x1, double up) {
        double ellipseSumAns = 0;
        for (int i = 1; i < (n+1); i++) {
            ellipseSumAns = ellipseSumAns+ellipseIntegralAlg(a, x, dimension, coef, (), up);
        }
        return ellipseSumAns;
    }
    // Ellipse delta variable
    private double ellipseDeltaAlg(int an, int am) {
        double delta = 1-(mathFuncs.power(an, 2)/mathFuncs.power(am, 2));
        return delta;
    }
}

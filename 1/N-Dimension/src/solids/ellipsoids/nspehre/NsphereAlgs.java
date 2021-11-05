package solids.ellipsoids.nspehre;

import java.math.BigDecimal;

import funcs.math.MathFuncs;
import java.math.RoundingMode;
import java.lang.Math;

public class NsphereAlgs {
    MathFuncs mathFuncs = new MathFuncs();
    public String volume(int dimension, int r) {
        BigDecimal volumeAns = new BigDecimal("0");
        BigDecimal radius = new BigDecimal(r);
        volumeAns = (
            ((new BigDecimal(Math.pow((mathFuncs.pi), (dimension/2)))).divide(
                new BigDecimal(mathFuncs.gammaFunc(((dimension/2)+1))), RoundingMode.HALF_UP)
            ).multiply(new BigDecimal(mathFuncs.power(r, dimension)))
        );
        return String.valueOf(volumeAns);
    }
}

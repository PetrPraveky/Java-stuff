package solids.ellipsoids.nspehre;

import java.math.BigDecimal;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import funcs.math.MathFuncs;

public class NsphereAlgs {
    MathFuncs mathFuncs = new MathFuncs();
    public String volume(int dimension, int r) {
        String volumeAns = null;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "python", System.getProperty("user.dir") + "\\lib\\python\\NsphereAlg.py",
                String.valueOf("volume"), String.valueOf(dimension), String.valueOf(r)
            );
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                volumeAns = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return volumeAns;
    }
}

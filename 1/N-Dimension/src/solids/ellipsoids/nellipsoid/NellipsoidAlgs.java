package solids.ellipsoids.nellipsoid;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import funcs.math.MathFuncs;

public class NellipsoidAlgs {
    MathFuncs mathFuncs = new MathFuncs();
    public String volume(int dimension, int r) {
        String volumeAns = null;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "python", System.getProperty("user.dir") + "\\lib\\python\\NellipAlg.py",
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
    public String surface(int dimension, int r) {
        String surfaceAns = null;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "python", System.getProperty("user.dir") + "\\lib\\python\\NellipAlg.py",
                String.valueOf("surface"), String.valueOf(dimension), String.valueOf(r)
            );
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                surfaceAns = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return surfaceAns;        
    }
    public String surfaceEq(int dimension) {
        StringBuilder surfaceEqAns = new StringBuilder(); 
        String line;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "python", System.getProperty("user.dir") + "\\lib\\python\\NsphereAlg.py",
                String.valueOf("surfaceEq"), String.valueOf(dimension), "1"
            );
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                while ((line = reader.readLine()) != null) {
                    if (String.valueOf(line).equals("1")) {
                    } else {surfaceEqAns.append(line);}
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(surfaceEqAns);        
    }
}

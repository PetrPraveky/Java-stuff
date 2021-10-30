package solids.ellipsoids;

import java.util.ArrayList;
import java.util.List;

import solids.ellipsoids.nellipsoid.NellipsoidAlgs;

public class NellipsoidOut {
    public NellipsoidOut(int dimension) {
        NellipsoidAlgs nellipsoidAlgs = new NellipsoidAlgs();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i<dimension; i++) {
            a.add((i+2));
        }
        System.out.println(a+"\n");
        System.out.println("Surface are of ellipsoid in "+dimension+"D: "+nellipsoidAlgs.nEllipseSurfaceAlg(a, dimension));
    }
}

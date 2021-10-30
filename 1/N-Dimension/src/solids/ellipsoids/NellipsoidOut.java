package solids.ellipsoids;

import java.util.ArrayList;
import java.util.List;

import solids.ellipsoids.nellipsoid.NellipsoidAlgs;

public class NellipsoidOut {
    public NellipsoidOut(int dimension) {
        NellipsoidAlgs nellipsoidAlgs = new NellipsoidAlgs();
        System.out.println("Surface are of ellipsoid in "+dimension+"D: "+nellipsoidAlgs.nEllipseSurfaceAlg(dimension));
    }
}

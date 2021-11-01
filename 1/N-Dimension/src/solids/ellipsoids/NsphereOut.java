package solids.ellipsoids;

import java.io.IOException;

import funcs.filesys.tex.nd.TexCommandsNsphere;
import solids.ellipsoids.nspehre.NsphereAlgs;
// Class for hyperspheres in n-dimensions
public class NsphereOut {
    public NsphereOut(int dimension, String folder) throws IOException {
        NsphereAlgs cNsphereAlgs = new NsphereAlgs();
        TexCommandsNsphere texCommands = new TexCommandsNsphere();
    }
}

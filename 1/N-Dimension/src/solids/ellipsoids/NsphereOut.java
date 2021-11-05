package solids.ellipsoids;

import java.io.IOException;
import java.math.BigDecimal;

import funcs.filesys.tex.nd.TexCommandsNsphere;
import solids.ellipsoids.nspehre.NsphereAlgs;
// Class for hyperspheres in n-dimensions
public class NsphereOut {
    public NsphereOut(int dimension, String folder) throws IOException {
        NsphereAlgs nSphereAlgs = new NsphereAlgs();
        TexCommandsNsphere texCommands = new TexCommandsNsphere();
        texCommands.texTitleOneNsphereCommand(dimension);
        // Data
        texCommands.texMiddleLine(1);
        // texCommands.texTitleSurfaceNSphereCommand(dimension);
        // texCommands.texMiddleLine(0.2);
        texCommands.texTitleVolumeNSphereCommand(dimension);
        if (dimension == 2) {
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1)))), "Area");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2)))), "Area");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 4)))), "Area");
        } else {
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1)))), "Volume");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2)))), "Volume");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 4)))), "Volume");
        }
        System.out.println("\\newpage");
    }
}

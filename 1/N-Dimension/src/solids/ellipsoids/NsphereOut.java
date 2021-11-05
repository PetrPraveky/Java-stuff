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
        // Volume
        texCommands.texTitleVolumeNSphereCommand(dimension);
        if (dimension == 2) {
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1)))), "Area");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2)))), "Area");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 4)))), "Area");
        } else {
            String volume1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand(volA1+"\\times{10^{"+volA2+"}}", "Area");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand(volume1, "Area");
            }
            volume1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand(volA1+"\\times{10^{"+volA2+"}}", "Area");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand(volume1, "Area");
            }
            volume1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 4))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand(volA1+"\\times{10^{"+volA2+"}}", "Area");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand(volume1, "Area");
            }
        }
        System.out.println("\\newpage");
    }
}

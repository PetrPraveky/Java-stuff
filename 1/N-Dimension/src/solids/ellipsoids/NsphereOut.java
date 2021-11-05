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
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1)))), "Area for $r = 1$");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2)))), "Area for $r = 2$");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 4)))), "Area for $r = 4$");
        } else {
            String volume1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+volume1, "Volume for $r = 1$");
            }
            volume1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+volume1, "Volume for $r = 2$");
            }
            volume1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 4))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume for $r = 4$");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+volume1, "Volume for $r = 4$");
            }
        }
        System.out.println("\\newpage");
    }
}

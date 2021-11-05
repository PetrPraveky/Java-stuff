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
        // Surface
        texCommands.texTitleSurfaceNSphereCommand(dimension);
        if (dimension == 2) {
            texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 1)))), "Radius for $r = 1$");
            texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 2)))), "Radius for $r = 2$");
            texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 4)))), "Radius for $r = 4$");
        } else {
            String surface1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 1))));
            try {
                int pos = (surface1.indexOf("e"));
                String surA1 = surface1.substring(0, pos);
                String surA2 = surface1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+surface1, "Surface for $r = 1$");
            }
            surface1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 2))));
            try {
                int pos = (surface1.indexOf("e"));
                String surA1 = surface1.substring(0, pos);
                String surA2 = surface1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+surface1, "Surface for $r = 2$");
            }
            surface1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 4))));
            try {
                int pos = (surface1.indexOf("e"));
                String surA1 = surface1.substring(0, pos);
                String surA2 = surface1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface for $r = 4$");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+surface1, "Surface for $r = 4$");
            }
        }
        texCommands.texMiddleLine(0.2);
        // Volume
        texCommands.texTitleVolumeNSphereCommand(dimension);
        if (dimension == 2) {
            texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1)))), "Area for $r = 1$");
            texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2)))), "Area for $r = 2$");
            texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 4)))), "Area for $r = 4$");
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

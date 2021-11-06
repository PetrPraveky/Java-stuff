package solids.ellipsoids;

import java.io.IOException;
import java.math.BigDecimal;

import funcs.filesys.tex.nd.TexCommandsNellip;
import funcs.filesys.tex.nd.TexCommandsNsphere;
import solids.ellipsoids.nellipsoid.NellipsoidAlgs;
import solids.ellipsoids.nspehre.NsphereAlgs;
// Class for hyperspheres in n-dimensions
public class NsphereEllOut {
    public NsphereEllOut(int dimension, String folder) throws IOException {
        // N-Sphere
        NsphereAlgs nSphereAlgs = new NsphereAlgs();
        TexCommandsNsphere texCommands = new TexCommandsNsphere();
        texCommands.texTitleOneNsphereCommand((dimension-1));
        // Data
        texCommands.texMiddleLine(1);
        // Surface
        if (dimension != 1) {
            texCommands.texTitleSurfaceNSphereCommand((dimension-1));
            if (dimension == 2) {
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 1)))), "Perimeter for $r = 1$");
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 2)))), "Perimeter for $r = 2$");
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 4)))), "Perimeter for $r = 4$");
            } else {
                String surface1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 1))));
                try {
                    int pos = (surface1.indexOf("e"));
                    String surA1 = surface1.substring(0, pos);
                    String surA2 = surface1.substring((pos+1));
                    texCommands.tex2ColumnDataNsphereCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface for $r = 1$");
                } catch (Exception e) {
                    texCommands.tex2ColumnDataNsphereCommand("\\approx "+surface1, "Surface for $r = 1$");
                }
                surface1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 2))));
                try {
                    int pos = (surface1.indexOf("e"));
                    String surA1 = surface1.substring(0, pos);
                    String surA2 = surface1.substring((pos+1));
                    texCommands.tex2ColumnDataNsphereCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface for $r = 2$");
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
        }
        // Volume
        texCommands.texTitleVolumeNSphereCommand((dimension-1));
        if (dimension == 1) {
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.1g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1)))), "Lenght for $r = 1$");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.1g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2)))), "Lenght for $r = 2$");
            texCommands.tex2ColumnDataNsphereCommand(String.format("%.1g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 4)))), "Lenght for $r = 4$");
        }
        else if (dimension == 2) {
            texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1)))), "Area for $r = 1$");
            texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2)))), "Area for $r = 2$");
            texCommands.tex2ColumnDataNsphereCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 4)))), "Area for $r = 4$");        } else {
            String volume1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 1))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume for $r = 1$");
            } catch (Exception e) {
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+volume1, "Volume for $r = 1$");
            }
            volume1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.volume(dimension, 2))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands.tex2ColumnDataNsphereCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume for $r = 2$");
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
        System.out.println("\\bigskip");
        System.out.println("\\bigskip");
        // N-Ellipsoid
        NellipsoidAlgs nellipsoidAlgs = new NellipsoidAlgs();
        TexCommandsNellip texCommands2 = new TexCommandsNellip();
        texCommands2.texTitleOneNellipseCommand((dimension-1));
        // Data
        texCommands2.texMiddleLine(1);
        // Surface
        if (dimension != 1) {
            texCommands2.texTitleSurfaceNellipseCommand((dimension-1));
            if (dimension == 2) {
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 1)))), "Perimeter for $r = 1$");
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 2)))), "Perimeter for $r = 2$");
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 4)))), "Perimeter for $r = 4$");
            } else {
                String surface1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 1))));
                try {
                    int pos = (surface1.indexOf("e"));
                    String surA1 = surface1.substring(0, pos);
                    String surA2 = surface1.substring((pos+1));
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface for $r = 1$");
                } catch (Exception e) {
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surface1, "Surface for $r = 1$");
                }
                surface1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 2))));
                try {
                    int pos = (surface1.indexOf("e"));
                    String surA1 = surface1.substring(0, pos);
                    String surA2 = surface1.substring((pos+1));
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface for $r = 2$");
                } catch (Exception e) {
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surface1, "Surface for $r = 2$");
                }
                surface1 = String.format("%.7g%n", (new BigDecimal(nSphereAlgs.surface(dimension, 4))));
                try {
                    int pos = (surface1.indexOf("e"));
                    String surA1 = surface1.substring(0, pos);
                    String surA2 = surface1.substring((pos+1));
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface for $r = 4$");
                } catch (Exception e) {
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surface1, "Surface for $r = 4$");
                }
            }
            texCommands.texMiddleLine(0.2);
        }
        // Volume
        texCommands2.texTitleVolumeNellipseCommand((dimension-1));
        if (dimension == 1) {
            texCommands2.tex2ColumnDataNellipseCommand(String.format("%.1g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 1)))), "Lenght for $r = 1$");
            texCommands2.tex2ColumnDataNellipseCommand(String.format("%.1g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 2)))), "Lenght for $r = 2$");
            texCommands2.tex2ColumnDataNellipseCommand(String.format("%.1g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 4)))), "Lenght for $r = 4$");
        }
        else if (dimension == 2) {
            texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 1)))), "Area for $r = 1$");
            texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 2)))), "Area for $r = 2$");
            texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 4)))), "Area for $r = 4$");        } else {
            String volume1 = String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 1))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume for $r = 1$");
            } catch (Exception e) {
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volume1, "Volume for $r = 1$");
            }
            volume1 = String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 2))));
            int r2 = 2; String r2String = "a_{1} = 2";
            if (dimension < 5) {
                for (int i = 1; i<dimension; i++) {
                    r2 = r2+2;
                    r2String = r2String+";   a_{"+(i+1)+"} = "+r2;
                }
            } else {
                for (int i = 1; i<dimension; i++) {
                    r2 = r2+2;
                }
                r2String = "a_{1} = 2;   a_{2} = 4 ;   ... ;   a_{"+dimension+"} = "+r2;
            }
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume for $"+r2String+"$");
            } catch (Exception e) {
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volume1, "Volume for $"+r2String+"$");
            }
            volume1 = String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 4))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume for $r = 4$");
            } catch (Exception e) {
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volume1, "Volume for $r = 4$");
            }
        }
        System.out.println("\\newpage");
    }
}

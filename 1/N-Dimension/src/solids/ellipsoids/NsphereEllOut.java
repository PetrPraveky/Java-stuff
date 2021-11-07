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
        texCommands.texMiddleLine(1);
        // Data
        if (dimension == 1) {
            // Volume eq
            texCommands.texTitleVolumeNsphereEqCommand(dimension, "Lenght equation for "+dimension+"-Shpere");
        } else if (dimension == 2) {
            // Surface eq
            texCommands.texTitleSurfaceNsphereEqCommand(dimension, "Perimeter equation for "+dimension+"-Sphere");
            // Volume eq
            texCommands.texTitleVolumeNsphereEqCommand(dimension, "Area equation for "+dimension+"-Sphere");
        } else {
            // Surface eq
            texCommands.texTitleSurfaceNsphereEqCommand(dimension, "Surface equation for "+dimension+"-Sphere");
            // Volume eq
            texCommands.texTitleVolumeNsphereEqCommand(dimension, "Volume equation for "+dimension+"-Sphere");
        }
        texCommands.texMiddleLine(0.2);
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
        // N-Ellipsoid
        NellipsoidAlgs nellipsoidAlgs = new NellipsoidAlgs();
        TexCommandsNellip texCommands2 = new TexCommandsNellip();
        int r1 = 1; String r1String = "a_{1} = 1";
        if (dimension < 4) {
            for (int i = 1; i<dimension; i++) {
                r1 = r1+1;
                r1String = r1String+";   a_{"+(i+1)+"} = "+r1;
            }
        } else {
            for (int i = 1; i<dimension; i++) {
                r1 = r1+1;
            }
            r1String = "a_{1} = 1;   a_{2} = 2 ;   ... ;   a_{"+dimension+"} = "+r1;
        }
        int r2 = 2; String r2String = "a_{1} = 2";
        if (dimension < 4) {
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
        int r3 = 4; String r3String = "a_{1} = 4";
        if (dimension < 4) {
            for (int i = 1; i<dimension; i++) {
                r3 = r3+4;
                r3String = r3String+";   a_{"+(i+1)+"} = "+r3;
            }
        } else {
            for (int i = 1; i<dimension; i++) {
                r3 = r3+4;
            }
            r3String = "a_{1} = 4;   a_{2} = 8 ;   ... ;   a_{"+dimension+"} = "+r3;
        }
        texCommands2.texTitleOneNellipseCommand((dimension-1));
        texCommands2.texMiddleLine(1);
        if (dimension == 1) {
            // Volume eq
            texCommands2.texTitleVolumeNellipseEqCommand(dimension, "Lenght equation for "+dimension+"-Ellipsoid");
        } else if (dimension == 2) {
            // Surface eq
            texCommands2.texTitleSurfaceNellipseEqCommand(dimension, "Perimeter equation for "+dimension+"-Ellipsoid");
            // Volume eq
            texCommands2.texTitleVolumeNellipseEqCommand(dimension, "Area equation for "+dimension+"-Ellipsoid");
        } else {
            // Surface eq
            texCommands2.texTitleSurfaceNellipseEqCommand(dimension, "Surface equation for "+dimension+"-Ellipsoid");
            // Volume eq
            texCommands2.texTitleVolumeNellipseEqCommand(dimension, "Volume equation for "+dimension+"-Ellipsoid");
        }
        // Data
        texCommands2.texMiddleLine(0.2);
        // Surface
        if (dimension != 1) {
            texCommands2.texTitleSurfaceNellipseCommand((dimension-1));
            if (dimension == 2) {
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.surface(dimension, 1)))), "Perimeter for $"+r1String+"$");
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.surface(dimension, 2)))), "Perimeter for $"+r2String+"$");
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.surface(dimension, 4)))), "Perimeter for $"+r3String+"$");
            } else {
                String surface1 = String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.surface(dimension, 1))));
                try {
                    int pos = (surface1.indexOf("e"));
                    String surA1 = surface1.substring(0, pos);
                    String surA2 = surface1.substring((pos+1));
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface for $"+r1String+"$");
                } catch (Exception e) {
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surface1, "Surface for $"+r1String+"$");
                }
                surface1 = String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.surface(dimension, 2))));
                try {
                    int pos = (surface1.indexOf("e"));
                    String surA1 = surface1.substring(0, pos);
                    String surA2 = surface1.substring((pos+1));
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface for $"+r2String+"$");
                } catch (Exception e) {
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surface1, "Surface for $"+r2String+"$");
                }
                surface1 = String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.surface(dimension, 4))));
                try {
                    int pos = (surface1.indexOf("e"));
                    String surA1 = surface1.substring(0, pos);
                    String surA2 = surface1.substring((pos+1));
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surA1+"\\times{10^{"+surA2+"}}", "Surface for $"+r3String+"$");
                } catch (Exception e) {
                    texCommands2.tex2ColumnDataNellipseCommand("\\approx "+surface1, "Surface for $"+r3String+"$");
                }
            }
            texCommands.texMiddleLine(0.2);
        }
        // Volume
        texCommands2.texTitleVolumeNellipseCommand((dimension-1));
        if (dimension == 1) {
            texCommands2.tex2ColumnDataNellipseCommand(String.format("%.1g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 1)))), "Lenght for $"+r1String+"$");
            texCommands2.tex2ColumnDataNellipseCommand(String.format("%.1g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 2)))), "Lenght for $"+r2String+"$");
            texCommands2.tex2ColumnDataNellipseCommand(String.format("%.1g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 4)))), "Lenght for $"+r3String+"$");
        }
        else if (dimension == 2) {
            texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 1)))), "Area for $"+r1String+"$");
            texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 2)))), "Area for $"+r2String+"$");
            texCommands2.tex2ColumnDataNellipseCommand("\\approx "+String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 4)))), "Area for $"+r3String+"$");        
        } else {
            String volume1 = String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 1))));
            try {
                int pos = (volume1.indexOf("e"));
                String volA1 = volume1.substring(0, pos);
                String volA2 = volume1.substring((pos+1));
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume for $"+r1String+"$");
            } catch (Exception e) {
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volume1, "Volume for $"+r1String+"$");
            }
            volume1 = String.format("%.7g%n", (new BigDecimal(nellipsoidAlgs.volume(dimension, 2))));
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
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volA1+"\\times{10^{"+volA2+"}}", "Volume for $"+r3String+"$");
            } catch (Exception e) {
                texCommands2.tex2ColumnDataNellipseCommand("\\approx "+volume1, "Volume for $"+r3String+"$");
            }
        }
        System.out.println("\\newpage");
    }
}

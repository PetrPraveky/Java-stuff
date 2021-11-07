package funcs.filesys.tex.nd;

import funcs.math.MathFuncs;
import solids.ellipsoids.nspehre.NsphereAlgs;

public class TexCommandsNellip {
    MathFuncs math = new MathFuncs();
    NsphereAlgs algs = new NsphereAlgs();
    public void texTitleOneNellipseCommand(int dimension) {
        String name = "";
        if (dimension == 0) {
            name = " (Line segment)";
        } else if (dimension == 1) {
            name = " (Ellipse)";
        } else if (dimension == 2) {
            name = " (Ellipsoid)";
        } else {}
        System.out.println("\\centerline{\\Large{\\textbf{"+dimension+"-Ellipsoid"+name+"}}}");
        System.out.println("\\bigskip");
    }
    public void texTitleVolumeNellipseCommand(int dimension) {
        if (dimension == 0) {
            System.out.println("\\large{\\textbf{Lenght of "+dimension+"-Ellipsoid:}}");
        } else if (dimension == 1) {
            System.out.println("\\large{\\textbf{Area of "+dimension+"-Ellipsoid:}}");
        } else {
            System.out.println("\\large{\\textbf{Volume of "+dimension+"-Ellipsoid:}}");
        }
    }
    public void texTitleSurfaceNellipseCommand(int dimension) {
        if (dimension == 1) {
            System.out.println("\\large{\\textbf{Perimeter of "+dimension+"-Ellipsoid:}}");
        } else {
            System.out.println("\\large{\\textbf{Surface of "+dimension+"-Ellipsoid:}}");
        }
    }
    public void texMiddleLine(double size) {
        System.out.println("\\centerline{\\par\\noindent\\rule{0.975\\textwidth}{"+size+"pt}}");
    }
    public void texTitleSurfaceNellipseEqCommand(int dimension, String name) {
        String r1String = ""; String ansString = ""; 
        int c = 0; int coef = 0; int d = 0;
        if (dimension < 4) {
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j<(dimension-1); j++) {
                    if ((j+c)==dimension) {
                        coef = 0;
                    }
                    else if ((j+c)>dimension) {
                        coef = d+1;
                        d++;
                    } else {
                        coef = j+c;
                    }
                    r1String = r1String+" a_{"+(coef+1)+"}";
                }
                ansString = ansString+("+("+r1String+")^{1.6075}");
                r1String = "";
                c++; d = 0;
            }
            ansString = "(\\frac{"+(ansString.substring(0))+"}{"+dimension+"})^{\\frac{1}{1.6075}}";
        } else {
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j<(dimension-1); j++) {
                    if ((j+c)==dimension) {
                        coef = 0;
                    }
                    else if ((j+c)>dimension) {
                        coef = d+1;
                        d++;
                    } else {
                        coef = j+c;
                    }
                    if (j==0) {
                        r1String = r1String+" a_{"+(coef+1)+"}";
                    } else if (j==(dimension-2)) {
                        r1String = r1String+"...a_{"+(coef+1)+"}";
                    }
                }
                ansString = ansString+("+("+r1String+")^{1.6075}");
                r1String = "";
                c++; d++;
            }
            c = 0; coef = 0; d = 0;
            for (int i = 0; i < dimension; i++) {
                r1String = "";
                for (int j = 0; j<(dimension-1); j++) {
                    if ((j+c)==dimension) {
                        coef = 0;
                    }
                    else if ((j+c)>dimension) {
                        coef = d+1;
                        d++;
                    } else {
                        coef = j+c;
                    }
                    if (j==0) {
                        r1String = r1String+" a_{"+(coef+1)+"}";
                    } else if (j==(dimension-2)) {
                        r1String = r1String+"...a_{"+(coef+1)+"}";
                    }
                }
                c++; d = 0;
            }
            ansString = "(\\frac{"+(ansString.substring(0))+"+...+("+r1String+")^{1.6075}}{"+dimension+"})^{\\frac{1}{1.6075}}";
        }
        System.out.println("\\begin{multicols}{2}");
        System.out.println("\\begin{flushleft}");
        System.out.println("\\textbf{- "+name+":}");
        System.out.println("\\end{flushleft}");
        System.out.println("\\columnbreak");
        System.out.println("\\begin{flushright}");
        System.out.println("\\textbf{$"+algs.surfaceEq(Integer.valueOf(dimension))+ansString+"$}");
        System.out.println("\\end{flushright}");
        System.out.println("\\end{multicols}");  
    }
    public void texTitleVolumeNellipseEqCommand(int dimension, String name) {
        String r1String = " a_{1}";
        if (dimension < 4) {
            for (int i = 1; i<dimension; i++) {
                r1String = r1String+"\\times{a_{"+(i+1)+"}}";
            }
        } else {
            r1String = "a_{1}\\times{a_{2}}\\times{...}\\times{a_{"+dimension+"}}";
        }
        System.out.println("\\begin{multicols}{2}");
        System.out.println("\\begin{flushleft}");
        System.out.println("\\textbf{- "+name+":}");
        System.out.println("\\end{flushleft}");
        System.out.println("\\columnbreak");
        System.out.println("\\begin{flushright}");
        System.out.println("\\textbf{$"+algs.volumeEq(Integer.valueOf(dimension))+r1String+"$}");
        System.out.println("\\end{flushright}");
        System.out.println("\\end{multicols}");  
    }
    public void tex2ColumnDataNellipseCommand(String count, String name) {
        System.out.println("\\begin{multicols}{2}");
        System.out.println("\\begin{flushleft}");
        System.out.println("- "+name+":");
        System.out.println("\\end{flushleft}");
        System.out.println("\\columnbreak");
        System.out.println("\\begin{flushright}");
        System.out.println("$"+count+"$");
        System.out.println("\\end{flushright}");
        System.out.println("\\end{multicols}");        
    }
}

package funcs.filesys.tex.nd;

import funcs.math.MathFuncs;

public class TexCommandsNellip {
    MathFuncs math = new MathFuncs();
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
        System.out.println("\\large{\\textbf{Volume of "+dimension+"-Ellipsoid:}}");
    }
    public void texTitleSurfaceNellipseCommand(int dimension) {
        System.out.println("\\large{\\textbf{Surface of "+dimension+"-Ellipsod:}}");
    }
    public void texMiddleLine(double size) {
        System.out.println("\\centerline{\\par\\noindent\\rule{0.975\\textwidth}{"+size+"pt}}");
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

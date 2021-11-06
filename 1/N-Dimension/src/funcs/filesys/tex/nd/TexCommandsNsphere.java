package funcs.filesys.tex.nd;

import funcs.math.MathFuncs;

public class TexCommandsNsphere {
    MathFuncs math = new MathFuncs();
    public void texTitleOneNsphereCommand(int dimension) {
        String name = "";
        if (dimension == 0) {
            name = " (Line segment)";
        } else if (dimension == 1) {
            name = " (Circle)";
        } else if (dimension == 2) {
            name = " (Sphere)";
        } else {}
        System.out.println("\\centerline{\\Large{\\textbf{"+dimension+"-Sphere"+name+"}}}");
        System.out.println("\\bigskip");
    }
    public void texTitleVolumeNSphereCommand(int dimension) {
        System.out.println("\\large{\\textbf{Volume of "+dimension+"-Sphere:}}");
    }
    public void texTitleSurfaceNSphereCommand(int dimension) {
        System.out.println("\\large{\\textbf{Surface of "+dimension+"-Sphere:}}");
    }
    public void texMiddleLine(double size) {
        System.out.println("\\centerline{\\par\\noindent\\rule{0.975\\textwidth}{"+size+"pt}}");
    }
    public void tex2ColumnDataNsphereCommand(String count, String name) {
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

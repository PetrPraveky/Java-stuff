package funcs.filesys.tex;

import funcs.math.MathFuncs;

public class TexCommands {
    MathFuncs math = new MathFuncs();
    public void texTitleOneNCubeCommand(int dimension) {
        String name = "";
        if (dimension == 2) {
            name = " (Square)";
        } else if (dimension == 3) {
            name = " (Cube)";
        } else if (dimension == 4) {
            name = " (Hypercube)";
        } else {}
        System.out.println("\\centerline{\\Large{\\textbf{"+dimension+"-Cube"+name+"}}}");
        System.out.println("\\bigskip");
    }
    public void texTitleDataNCubeCommand(int dimension) {
        System.out.println("\\large{\\textbf{Vertices; Edges; Faces; Cell count for "+dimension+"-Cube:}}");
    }
    public void texTitleValNCubeCommand(int dimension) {
        System.out.println("\\large{\\textbf{Solid values for "+dimension+"-Cube:}}");
    }
    public void tex2ColumnDataNCubeCommand(String count, String name) {
        System.out.println("\\begin{multicols}{2}");
        System.out.println("- "+name+" count:");
        System.out.println("\\columnbreak");
        System.out.println("\\begin{flushright}");
        System.out.println(count);
        System.out.println("\\end{flushright}");
        System.out.println("\\end{multicols}");
    }
    public void tex2Volume(int dimension, int r, String rString) {
        String name = "Volume";
        if (dimension == 2) {
            name = "Area";
        } else {}
        System.out.println("\\begin{multicols}{2}");
        System.out.println("- "+name+rString+":");
        System.out.println("\\columnbreak");
        System.out.println("\\begin{flushright}");
        if (r==0) {
            System.out.println("$a^{"+dimension+"}$");
        } else {
            System.out.println(math.bigPower(String.valueOf(r), String.valueOf(dimension)));
        }
        System.out.println("\\end{flushright}");
        System.out.println("\\end{multicols}");
    }        
}

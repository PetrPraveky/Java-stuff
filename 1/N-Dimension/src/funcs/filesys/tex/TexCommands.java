package funcs.filesys.tex;

import java.math.BigInteger;

import funcs.math.MathFuncs;
import java.lang.Math;
import solids.platonic_solids.ncube.NcubeAlgs;

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
    public void texMiddleLine(double size) {
        System.out.println("\\centerline{\\par\\noindent\\rule{0.975\\textwidth}{"+size+"pt}}");
    }
    public void tex2ColumnDataNCubeCommand(String count, String name) {
        System.out.println("\\begin{multicols}{2}");
        System.out.println("\\begin{flushleft}");
        System.out.println("- "+name+" count:");
        System.out.println("\\end{flushleft}");
        System.out.println("\\columnbreak");
        System.out.println("\\begin{flushright}");
        System.out.println("$"+count+"$");
        System.out.println("\\end{flushright}");
        System.out.println("\\end{multicols}");
    }
    public void tex2Volume(int dimension, int r, String rString) {
        String name = "Volume";
        if (dimension == 2) {
            name = "Area";
        } else {}
        System.out.println("\\begin{multicols}{2}");
        System.out.println("\\begin{flushleft}");
        System.out.println("- "+name+rString+":");
        System.out.println("\\end{flushleft}");
        System.out.println("\\columnbreak");
        System.out.println("\\begin{flushright}");
        if (r==0) {
            System.out.println("$a^{"+dimension+"}$");
        } else {
            System.out.println("$"+math.bigPower(String.valueOf(r), String.valueOf(dimension))+"$");
        }
        System.out.println("\\end{flushright}");
        System.out.println("\\end{multicols}");
    }   
    public void tex2Surface(int dimension, int r, String rString) {
        NcubeAlgs nCubeAlgs = new NcubeAlgs();
        String name = "Surface";
        if (dimension == 1) {
            name = "Lenght";
        } else if (dimension == 2) {
            name = "Perimeter";
        }
        if (dimension == 1) {
            System.out.println("\\begin{multicols}{2}");
            System.out.println("\\begin{flushleft}");
            System.out.println("- "+name+rString+":");
            System.out.println("\\end{flushleft}");
            System.out.println("\\columnbreak");
            System.out.println("\\begin{flushright}");
            if (r==0) {
                System.out.println("$a$");
            } else {
                System.out.println("$"+r+"$");
            }
            System.out.println("\\end{flushright}");
            System.out.println("\\end{multicols}");          
        } else if (dimension == 2) {
            System.out.println("\\begin{multicols}{2}");
            System.out.println("\\begin{flushleft}");
            System.out.println("- "+name+rString+":");
            System.out.println("\\end{flushleft}");
            System.out.println("\\columnbreak");
            System.out.println("\\begin{flushright}");
            if (r==0) {
                System.out.println("$"+nCubeAlgs.cellAlgDef(String.valueOf(dimension))+"a$");
            } else {
                System.out.println("$"+String.valueOf((new BigInteger(nCubeAlgs.cellAlgDef(String.valueOf(dimension)))).multiply(new BigInteger(math.bigPower(String.valueOf(new BigInteger(String.valueOf(r))), String.valueOf(new BigInteger(String.valueOf((dimension-1))))))))+"$");
            }
            System.out.println("\\end{flushright}");
            System.out.println("\\end{multicols}");             
        } else {
            System.out.println("\\begin{multicols}{2}");
            System.out.println("\\begin{flushleft}");
            System.out.println("- "+name+rString+":");
            System.out.println("\\end{flushleft}");
            System.out.println("\\columnbreak");
            System.out.println("\\begin{flushright}");
            if (r==0) {
                System.out.println("$"+nCubeAlgs.cellAlgDef(String.valueOf(dimension))+"a^{"+(dimension-1)+"}$");
            } else {
                System.out.println("$"+String.valueOf((new BigInteger(nCubeAlgs.cellAlgDef(String.valueOf(dimension)))).multiply(new BigInteger(math.bigPower(String.valueOf(new BigInteger(String.valueOf(r))), String.valueOf(new BigInteger(String.valueOf((dimension-1))))))))+"$");
            }
            System.out.println("\\end{flushright}");
            System.out.println("\\end{multicols}");
        }
    }
    public void tex2DiagonalCommand(int dimension, int r, String rString) {
        NcubeAlgs nCubeAlgs = new NcubeAlgs();
        String name = "Diagonal";
        System.out.println("\\begin{multicols}{2}");
        System.out.println("\\begin{flushleft}");
        System.out.println("- "+name+rString+":");
        System.out.println("\\end{flushleft}");
        System.out.println("\\columnbreak");
        System.out.println("\\begin{flushright}");
        if (r==0) {
            if ((Math.sqrt(dimension)-Math.floor(Math.sqrt(dimension)))==0) {
                System.out.println("$a\\sqrt{"+dimension+"}\\quad;\\quad"+((int)(Math.sqrt(dimension)))+"a$");
            } else {
                System.out.println("$a\\sqrt{"+dimension+"}$");
            }
        } else {
            double ans = nCubeAlgs.diagonalAlg(dimension, r);
            if (ans==Math.floor(ans)) {
                System.out.println("$"+r+"\\sqrt{"+dimension+"}\\quad;\\quad"+((int)ans)+"$");
            } else {
                System.out.println("$"+r+"\\sqrt{"+dimension+"}\\quad;\\quad"+String.format("%.7g%n", ans)+"...$");
            }
        }
        System.out.println("\\end{flushright}");
        System.out.println("\\end{multicols}");  
    }
}

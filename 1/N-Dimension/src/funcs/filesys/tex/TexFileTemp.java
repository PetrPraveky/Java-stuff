package funcs.filesys.tex;

import java.util.Date;

public class TexFileTemp {
    TexCommands texCommands = new TexCommands();
    public void texFileBeg() {
        System.out.println("\\documentclass[a4paper,10pt]{article}\n");
        System.out.println("\\renewcommand{\\familydefault}{\\sfdefault}\n");

        System.out.println("\\usepackage[a4paper, inner=1.7cm, outer=2.7cm, top=2cm, bottom=2cm, bindingoffset=1.2cm]{geometry}");
        System.out.println("\\usepackage{amsmath}");
        System.out.println("\\usepackage{multicol}");
        System.out.println("\\usepackage[english]{babel}");
        System.out.println("\\usepackage{blindtext}\n");

        System.out.println("\\begin{document}");
    }
    public void texFileTitle(String title) {
        System.out.println("\\title{\\Large{\\textbf{"+title+"}}}");
        System.out.println("\\author{By Peter Kučera}");
        Date currentDate = new Date();
        System.out.println("\\date{"+currentDate+"}");
        System.out.println("\\maketitle");
        System.out.println("\\newpage");
    }
    public void texFileInfoPageNcube() {
        System.out.println("\\centerline{\\Large{\\textbf{N-Dimensional Cube Terminology and Formulas}}}");
        texCommands.texMiddleLine(1);
        // System.out.println("\\vspace{\\baselineskip}");
        System.out.println("\\begin{flushleft}");
        // Terminology
        System.out.println("""
            \\null\\large{\\quad Firstly let me talk about some terminilogy used in this document. There are some terms, that are not that obvious or maybe 
            could mean something different than usual, so I will try my best to explain them.
            }\\newline""");
        System.out.println("""
            \\null\\large{\\quad \"Vertex\" (or Vertices) is zero dimensional object (point), that is part of objects, in this scenario, cubes, in higher dimensions.
            By connecting two vertices you make a line, or \"edge\". By crossing two same edges, thanks to second dimension (you can't do that in 1D), you make on vertex of square.
            When you complete this square by the same technigue, it is named \"face\". Again, if you align three faces with same vertex and bend it
            into third dimension, you create a one vertex of cube. Again by completing this cube, you can name in \"cell\". You can continue and name another objects in
            higher dimensions, but I didn't do that and I only use these four terms. So Vertex mean zero dimensional part of object; Edge is one dimensional part of object of
            certain lenght; Face is two dimensional part of object, square, made of four same edges; And Cell is third dimensional part of object, cube, made of six same
            faces. You can find number of those in higher dimensional cubes later in this document. Also by \"leght a\" or \"side lenght a\" I mean specific lenght of edge.
            }\\newline""");
        System.out.println("""
            \\null\\large{
                \\quad In this part I'll explain some formulas used to compute data, that is in this document. There will be a bit more explaining and
                lot of math. By \"$n$\" I mean the dimension number.
            }\\newline
            \\null\\large{
                \\quad First formula used is equation for computing number of vertices \"$V$\" of $n$ dimensional object, cube. It is exponential function with
                base of $2$ and exponent $n$. So the equation looks like this:} \\newline
            \\null\\centerline\\Large{
                $V = 2^{n}$
            }\\newline""");

        // System.out.println("\\large{\\textbf{Base Terminology:}}\\newline");
        // System.out.println("\\large{haha}\\newline");
        // System.out.println("\\large{For Dimension $n$; Side lenght $a$}\\newline");
        // System.out.println("\\vspace{\\baselineskip}");
        // Equations
        // System.out.println("\\textbf{Used Formulas:}\\newline");
        // System.out.println("\\large{- Equation for verticies count:}\\quad\\quad$2^{n}$\\newline");
        // System.out.println("\\large{- Equation for edge count:}\\quad\\quad$2^{n}$\\newline");



        System.out.println("\\end{flushleft}");

        System.out.println("\\newpage");
    }
}

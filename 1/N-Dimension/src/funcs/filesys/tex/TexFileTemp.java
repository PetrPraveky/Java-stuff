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
        System.out.println("\\usepackage{xfrac}");

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
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad \"Vertex\" (or Vertices) is zero dimensional object (point), that is part of objects, in this scenario, cubes, in higher dimensions.
                By connecting two vertices you make a line, or \"edge\". By crossing two same edges, thanks to second dimension (you can't do that in 1D), you make on vertex of square.
                When you complete this square by the same technigue, it is named \"face\". Again, if you align three faces with same vertex and bend it
                into third dimension, you create a one vertex of cube. Again by completing this cube, you can name in \"cell\". You can continue and name another objects in
                higher dimensions, but I didn't do that and I only use these four terms. So Vertex mean zero dimensional part of object; Edge is one dimensional part of object of
                certain lenght; Face is two dimensional part of object, square, made of four same edges; And Cell is third dimensional part of object, cube, made of six same
                faces. You can find number of those in higher dimensional cubes later in this document.
            }

        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad By \"leght a\" or \"side lenght a\" I mean specific lenght of edge. By using volume I mean amount of space inside $n$ dimensional object.
                Because here we are talking about cubes, \"Volume\" (or \"Area\" in 2D) is computed by taking one edge and giving it to the power of $n$. I didn't write volume for
                in 0D and 1D, because it is obvious. \"Surface\" (or \"Perimeter\" that is used in square) is meant the sum of volumes of $n-1$ dimension objects. 
                I didn't write surface in 0D, because it is obvious. Lastly \"Diagonal\" is line, that connects two vertices agains each other. If we want
                diagonal of cube, 3D object, we must connect vertices, that aren't at the same face. This also applies to higher dimensions. Diagonal is non-existent in 1D and 0D.
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("\\vspace{\\baselineskip}");
        System.out.println("""
            \\null\\large{
                \\quad In this part I'll explain some formulas used to compute data, that is in this document. There will be a bit more explaining and
                lot of math. By \"$n$\" I mean the dimension number.
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad First formula used is equation for computing the number of vertices \"$V$\" of $n$ dimensional object, cube. It is exponential function with
                base of $2$ and exponent $n$. So the equation looks like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $V = 2^{n}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad Second equation is used for computing the number of edges \"$E$\" of $n$ dimensional object, cube. This one is little bit more complex than the
                first one. It is defined by exponenatial function with base of $2$ and exponent $n-1$ and than multiplied by $n$. So it looks like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $E = n\\times2^{(n-1)}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad Another formula is used for computing number of $n-1$ dimensional parts in $n$ dimensional object, cube. I used this fot computing number of faces and
                cells. We can use $n$ for our dimension and $m$ for dimension in wich we want to get number of parts. We can name it \"$X$\" for more usage in future parts. 
                So basic equation is this:} \\newline
            \\null\\centerline{
                \\Large{
                    $X = 2^{n-m}\\times(\\frac{n!}{m!(n-m)!})$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\newpage
            \\null\\large{
                \\quad We can easily modify it to compute the number of faces \"$F$\" and number of cells \"$C$\". Again $n$ stands for dimension number So the modified formulas look like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $F = 2^{n-2}\\times(\\frac{n!}{2!(n-2)!})$
                }
            }\\newline
            \\null\\centerline{
                \\Large{
                    $C = 2^{n-3}\\times(\\frac{n!}{2!(n-3)!})$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad Equation for volume \"$V_n$\" comes from assumption, that if we put lenght $a$ to the power on $n$, we'll get amount of inner space of $n$ dimensional object.
                So the equation looks like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $V_n = a^{n}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad Equation for surface \"$S_n$\" comes from assumption, that surface means sum of $n-1$ dimensional parts of $n$ dimensional object. So
                surface of Hypercube (4D cube) is equal to sum of volumes of 3D cubes. This equation is little more complex and it uses $X$, 
                what it means we already established with $m = n-1$:} \\newline
            \\null\\centerline{
                \\Large{
                    $S_n = X\\times{a^{n-1}}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad And we can simplify it like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $S_n = 2\\times{(\\frac{n!}{(n-1)!})}\\times{a^{n-1}}$
                }
            }
        """);
        System.out.println("""
            \\null\\large{
                \\quad Again, equation for diagonal \"$D_n$\" of $n$ dimensional object comes from assumption that \"Pythagorean theorem\" can be extended
                to higher dimensions. So we can describe it by infinite series like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $(R_n)^{\\infty}_{n=1} \\quad ; \\quad R_{n+1}=\\sqrt{R_n^{2}+a^{2}} \\quad ; \\quad R_1 = a^{2}$
                }
            }
        """);

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

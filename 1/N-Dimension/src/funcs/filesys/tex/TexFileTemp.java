package funcs.filesys.tex;

import funcs.filesys.tex.nd.*;

public class TexFileTemp {
    TexCommandsNcube texCommands = new TexCommandsNcube();
    public void texFileBeg(String imgFolder) {
        System.out.println("\\documentclass[a4paper,10pt]{article}\n");
        System.out.println("\\renewcommand{\\familydefault}{\\sfdefault}\n");

        System.out.println("\\usepackage[a4paper, inner=1.7cm, outer=2.7cm, top=2cm, bottom=2cm, bindingoffset=1.2cm]{geometry}");
        System.out.println("\\usepackage{amsmath}");
        System.out.println("\\usepackage{multicol}");
        System.out.println("\\usepackage[english]{babel}");
        System.out.println("\\usepackage{blindtext}\n");
        System.out.println("\\usepackage{xfrac}");
        System.out.println("\\usepackage{yfonts}");

        System.out.println("\\graphicspath{{"+imgFolder+"}}");

        System.out.println("\\begin{document}");
    }
    public void texFileTitle(String title) {
        System.out.println("\\title{\\Large{\\textbf{"+title+"}}}");
        System.out.println("\\author{By Peter Kučera}");
        System.out.println("\\maketitle");
        System.out.println("\\newpage");
    }
    public void texFileInfoPageNcube() {
        System.out.println("\\centerline{\\Large{\\textbf{N-Dimensional Cube Terminology and Formulas}}}");
        texCommands.texMiddleLine(1);
        System.out.println("\\begin{flushleft}");
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
                certain length; Face is two dimensional part of object, square, made of four same edges; And Cell is third dimensional part of object, cube, made of six same
                faces. You can find number of those in higher dimensional cubes later in this document.
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad By \"length a\" or \"side length a\" I mean specific length of edge. By using volume I mean amount of space inside $n$ dimensional object.
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
                \\quad Equation for volume \"$V_n$\" comes from assumption, that if we put length $a$ to the power on $n$, we'll get amount of inner space of $n$ dimensional object.
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
                    $A_n = X\\times{a^{n-1}}\\quad ; \\quad A_n = 2^{n-m}\\times(\\frac{n!}{m!(n-m)!})\\times{a^{n-1}}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad And we can simplify it like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $A_n = 2\\times{(\\frac{n!}{(n-1)!})}\\times{a^{n-1}}$
                }
            }
        """);
        System.out.println("""
            \\null\\large{
                \\quad Again, equation for diagonal \"$D_n$\" of $n$ dimensional object comes from assumption that \"Pythagorean theorem\" can be extended
                to higher dimensions. So we can describe it by infinite series like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $(D_n)^{\\infty}_{n=1} \\quad ; \\quad D_{n+1}=\\sqrt{D_n^{2}+a^{2}} \\quad ; \\quad D_1 = a^{2}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad Wich can be simplyfied:} \\newline
            \\null\\centerline{
                \\Large{
                    $D_n = a\\times{\\sqrt{n}}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad Lastly I want to talk about visualization of those cubes. I only have visual representation of up to 15 dimensional cubes in 2D.
                I'm not capable to create all 20, well not now. Visualization of 0D cube also missing, because it is single point in space and I think it is
                useless to create that.
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad Those visualizations are created by simple, but complex program, that creates all vertices at first and then it connects them togeter in
                certain way, to create this representation of $n$ dimenion on 2D space.
            }
        """);
        System.out.println("\\end{flushleft}");
        System.out.println("\\newpage");
    }
    public void texFileInfoPageNsphere() {
        System.out.println("\\centerline{\\Large{\\textbf{N-Dimensional Cube Terminology and Formulas}}}");
        texCommands.texMiddleLine(1);
        System.out.println("\\begin{flushleft}");
        System.out.println("""
            \\null\\large{\\quad Firstly let me talk about some terminilogy used in this document. There are some terms, that are not that obvious or maybe 
            could mean something different than usual, so I will try my best to explain them.
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
            \\null\\large{
                \\quad N-dimensional sphere and ellipsoid is defined as $n$ surface and $n+1$ ball ($n+1$ volume).
                So for example \"3-sphere\" is sphere in fourth dimension. All semiaxes in n-ellipsoid are defined by this infinite series with lenght $l$:} \\newline
                \\null\\centerline{
                    \\Large{
                        $(a_{n})^{\\infty}_{n=1} \\quad ; \\quad a_{n+1}=a_{n}+l \\quad ; \\quad a_{1}=l$
                    }
                }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
        \\null\\large{
            \\quad Now, lets talk about \"Volume\" \\& \"Surface\" of n-sphere. Firstly about volume. Volume is defined by this equation using Euler's gamma function and
            radius $r$:} \\newline
            \\null\\centerline{
                \\Large{
                    $V_{sn} = \\frac{\\pi^{\\frac{n}{2}}}{\\Gamma(\\frac{n}{2}-1)}r^{n}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
        \\null\\large{
            \\quad Surface of n-sphere is defined again by equation using radius $r$ and gamma function:} \\newline
            \\null\\centerline{
                \\Large{
                    $S_{sn} = \\frac{2\\pi^{\\frac{n}{2}}}{\\Gamma(\\frac{n}{2})}r^{n-1}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
        \\null\\large{
            \\quad Volume for n-ellipsoids is very simillar to volume of n-spheres. Instead of one radius $r$, there are used all semiaxis $a$. So the final
            equation looks like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $V_{en} = \\frac{\\pi^{\\frac{n}{2}}}{\\Gamma(\\frac{n}{2}-1)}a_{1}\\times{a_{2}}\\times{...}\\times{a_{n}}$
                }
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
        \\null\\large{
            \\quad Equation for surface of n-ellipsoid is little bit more different then equation for surface of n-shpere. Base is same, but instead of $r$,
            there is used approximate equation. Output of this equation is more or less equal to $r^{n-1}$ in equation for surface of n-sphere.
            This equation looks like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $\\textfrak{m}=(\\frac{1}{n}\\sum_{i=1}^{\\infty}x_{i}^{p})^{p}$}
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
        \\null\\large{
            \\quad where constant $p=1.6075$ and $x$ is certain multiplication of semiaxis a. It is defined like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $x_{1}=a_{1}\\times{a_{2}}\\times{...}\\times{a_{n-1}}$}
            }
            \\null\\centerline{
                \\Large{
                    $x_{2}=a_{2}\\times{a_{3}}\\times{...}\\times{a_{n}}$}
            }
            \\null\\centerline{
                \\Large{
                    $x_{3}=a_{3}\\times{a_{4}}\\times{...}\\times{a_{n}}\\times{a_{1}}$}
            }
            \\null\\centerline{
                \\Large{
                    $.$}
            }
            \\null\\centerline{
                \\Large{
                    $.$}
            }
            \\null\\centerline{
                \\Large{
                    $.$}
            }
            \\null\\centerline{
                \\Large{
                    $x_{n}=a_{n}\\times{a_{1}}\\times{...}\\times{a_{n-2}}$}
            }
        """);
        System.out.println("\\vspace{-5pt}");
        System.out.println("""
        \\null\\large{
            \\quad So the final equation for surface looks like this:} \\newline
            \\null\\centerline{
                \\Large{
                    $S_{en} = \\frac{2\\pi^{\\frac{n}{2}}}{\\Gamma(\\frac{n}{2})}\\textfrak{m}\\quad ; \\quad S_{en} = \\frac{2\\pi^{\\frac{n}{2}}}{\\Gamma(\\frac{n}{2})}(\\frac{1}{n}\\sum_{i=1}^{\\infty}x_{i}^{p})^{p}$}
            }
        """);
        System.out.println("\\end{flushleft}");
        System.out.println("\\newpage");
    }
}

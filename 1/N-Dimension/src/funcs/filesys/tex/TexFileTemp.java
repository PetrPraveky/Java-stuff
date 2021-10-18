package funcs.filesys.tex;

import java.util.Date;

public class TexFileTemp {
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
        System.out.println("\\centerline{\\Large{\\textbf{N-Dimensional Cube Information}}}");
        // System.out.println("\\vspace{\\baselineskip}");
        // Terminology
        System.out.println("\\begin{flushleft}");
        System.out.println("\\large{\\textbf{Base Terminology:}}\\newline");
        System.out.println("\\large{haha}\\newline");
        System.out.println("\\large{For Dimension $n$; Side lenght $a$}\\newline");
        // System.out.println("\\vspace{\\baselineskip}");
        // Equations
        System.out.println("\\textbf{Used Equations:}\\newline");
        System.out.println("\\large{- Equation for verticies count:}\\quad\\quad$2^{n}$\\newline");
        System.out.println("\\large{- Equation for edge count:}\\quad\\quad$2^{n}$\\newline");
        System.out.println("\\end{flushleft}");

        System.out.println("\\newpage");
    }
}

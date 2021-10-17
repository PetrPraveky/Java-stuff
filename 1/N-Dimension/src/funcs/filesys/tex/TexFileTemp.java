package funcs.filesys.tex;

import java.util.Date;

public class TexFileTemp {
    public void texFileBeg() {
        System.out.println("\\documentclass[a4paper,12pt]{article}\n");
        System.out.println("\\renewcommand{\\familydefault}{\\sfdefault}\n");

        System.out.println("\\usepackage[a4paper, inner=1.7cm, outer=2.7cm, top=2cm, bottom=2cm, bindingoffset=1.2cm]{geometry}");
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
}

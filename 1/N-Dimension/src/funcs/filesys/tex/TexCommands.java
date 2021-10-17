package funcs.filesys.tex;

public class TexCommands {
    public void texTitleOneCommand(int dimension) {
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
    public void texTitleTwoCommand(int dimension) {
        System.out.println("\\Large{\\textbf{Vertices; Edges; Faces; Cell count for"+dimension+"-Cube:}}\\newline");
    }
    public void tex2ColumnCommand(String count, String name) {
        System.out.println("\\begin{multicols}{2}");
        System.out.println("\\textbf{- "+name+" count:}");
        System.out.println("\\columnbreak");
        System.out.println(count);
        System.out.println("\\end{multicols}");
    }
}

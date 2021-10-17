package solids.platonic_solids;
import java.math.BigInteger;

import funcs.filesys.tex.TexCommands;
import solids.platonic_solids.ncube.NcubeAlgs;
// Class for hypercubes in n-dimensions
public class NcubeOut {
    public NcubeOut(int dimension) {
        NcubeAlgs nCubeAlgs = new NcubeAlgs();
        TexCommands texCommands = new TexCommands();
        BigInteger vertNum = new BigInteger(nCubeAlgs.vertices(Integer.toString(dimension)));
        BigInteger edgNum = new BigInteger(nCubeAlgs.edges(Integer.toString(dimension)));
        BigInteger faceNum = new BigInteger(nCubeAlgs.faces(Integer.toString(dimension)));
        BigInteger cellNum = new BigInteger(nCubeAlgs.cells(Integer.toString(dimension)));

        texCommands.texTitleOneNCubeCommand(dimension);
        texCommands.texTitleDataNCubeCommand(dimension);
        texCommands.tex2ColumnDataNCubeCommand(String.valueOf(vertNum), "Vertices");
        texCommands.tex2ColumnDataNCubeCommand(String.valueOf(edgNum), "Edges");
        texCommands.tex2ColumnDataNCubeCommand(String.valueOf(faceNum), "Faces");
        texCommands.tex2ColumnDataNCubeCommand(String.valueOf(cellNum), "Cells");

        // System.out.println("----------------------------------------------------------------------\\linebreak");
        // System.out.println("Vertices, edges, faces and cells count for "+dimension+"-D cube:\\linebreak");
        // System.out.println("- Vertices count:    "+String.valueOf(vertNum));
        // System.out.println("- Edges count:       "+String.valueOf(edgNum));
        // System.out.println("- Faces count:       "+String.valueOf(faceNum));
        // System.out.println("- Cells (3D) count:  "+String.valueOf(cellNum));
        texCommands.texTitleValNCubeCommand(dimension);
        if (dimension != 0) {
            if (dimension == 1) {

            } else {
                texCommands.tex2Volume(dimension, 0, "");
                texCommands.tex2Volume(dimension, 1, " (with side lenght $a = 1$)");
                texCommands.tex2Volume(dimension, 2, " (with side length $a = 2$)");
                // System.out.println("Shape values for "+dimension+"-D cube");
                // System.out.println("- Volume:            a"+dimension);
                System.out.println("- Surface area (2D): "+nCubeAlgs.faces(Integer.toString(dimension))+"a2");
            }
        } else {
            System.out.println("\\begin{multicols}{2}");
            System.out.println("- None");
            System.out.println("\\end{multicols}");
        }
        System.out.println("\\newpage");
    }
}
package solids.platonic_solids;
import java.math.BigInteger;
import solids.platonic_solids.ncube.NcubeAlgs;
// Class for hypercubes in n-dimensions
public class NcubeOut {
    public NcubeOut(int dimension) {
        NcubeAlgs nCubeAlgs = new NcubeAlgs();
        BigInteger vertNum = new BigInteger(nCubeAlgs.vertices(Integer.toString(dimension)));
        BigInteger edgNum = new BigInteger(nCubeAlgs.edges(Integer.toString(dimension)));
        BigInteger faceNum = new BigInteger(nCubeAlgs.faces(Integer.toString(dimension)));
        BigInteger cellNum = new BigInteger(nCubeAlgs.cells(Integer.toString(dimension)));

        

        // System.out.println("----------------------------------------------------------------------\\linebreak");
        System.out.println("Vertices, edges, faces and cells count for "+dimension+"-D cube:\\linebreak");
        System.out.println("- Vertices count:    "+String.valueOf(vertNum));
        System.out.println("- Edges count:       "+String.valueOf(edgNum));
        System.out.println("- Faces count:       "+String.valueOf(faceNum));
        System.out.println("- Cells (3D) count:  "+String.valueOf(cellNum));
        System.out.println("Shape values for "+dimension+"-D cube");
        System.out.println("- Volume:            a"+dimension);
        System.out.println("- Surface area (2D): "+nCubeAlgs.faces(Integer.toString(dimension))+"a2");
        System.out.println("\\newpage");

    }
}
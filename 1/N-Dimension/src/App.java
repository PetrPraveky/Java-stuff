// import solids.ellipsoids.NellipsoidOut;
import funcs.math.MathFuncs;
// import solids.platonic_solids.ncube.NcubeGraphAlgs;
import funcs.filesys.FolderCreate;

// Program for computing stuff for higher dimensions
public class App {
    public static void main(String[] args) throws Exception {
        // new NellipsoidOut(3);
        // new FolderCreate();
        // new NcubeGraphAlgs(".", 19);
        // for (int i = 2; i<11; i++) {
        //     new NcubeGraphAlgs(".", i);
        // }
        MathFuncs mathFuncs = new MathFuncs();
        mathFuncs.gammaFunction("0");
    }
}
// import solids.ellipsoids.NellipsoidOut;
import funcs.math.MathFuncs;
// import solids.platonic_solids.ncube.NcubeGraphAlgs;
import funcs.filesys.FolderCreate;
import solids.ellipsoids.nspehre.NsphereAlgs;

// Program for computing stuff for higher dimensions
public class App {
    public static void main(String[] args) throws Exception {
        NsphereAlgs algs = new NsphereAlgs();
        // System.out.println((algs.surface(4, 1)));
        // System.out.println(algs.volumeEq(1));
        // System.out.println(algs.volumeEq(4));
        // MathFuncs math = new MathFuncs();
        // System.out.println(math.gammaFunc(2));
        new FolderCreate();
        // new NellipsoidOut(3);
        // new NcubeGraphAlgs(".", 19);
        // for (int i = 2; i<11; i++) {
        //     new NcubeGraphAlgs(".", i);
        // }
    }
}

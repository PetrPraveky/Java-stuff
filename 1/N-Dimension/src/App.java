import java.util.List;
import funcs.filesys.FolderCreate;
import funcs.math.MathFuncs;
// import solids.platonic_solids.ncube.NcubeGraphAlgs;

// Program for computing stuff for higher dimensions
public class App {
    public static void main(String[] args) throws Exception {
        MathFuncs mathFuncs = new MathFuncs();
        List<Integer> a = List.of(2, 3, 4);
        mathFuncs.ellipseIntegralFunc(a, 1, 3, true);
        // new FolderCreate();
        // new NcubeGraphAlgs(".", 19);
        // for (int i = 2; i<11; i++) {
        //     new NcubeGraphAlgs(".", i);
        // }
    }
}
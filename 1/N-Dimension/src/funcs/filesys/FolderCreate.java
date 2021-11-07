package funcs.filesys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import funcs.filesys.tex.TexFileTemp;
import solids.ellipsoids.NsphereEllOut;
import solids.platonic_solids.*;

//Function for creating folders and files with data
public class FolderCreate {
    File mainDir = new File(".output");;
    TexFileTemp texFileTemp = new TexFileTemp();
    int dimNumMax = 6;
    
    public FolderCreate() throws Exception {
        // Main answer directory
        if (!mainDir.exists()) {
            mainDir.mkdirs();
        } else {}
        ellipsoidsOutput();
        // platonicSolidsOutputs();
    }
    private void platonicSolidsOutputs() throws Exception {
        // Platonic solids direcotry
        File platDir = new File(mainDir+"/platonic_solids");
        if (!platDir.exists()) {
            platDir.mkdirs();
        } else {}
        ncubeOutput(platDir);
    }
    private void ellipsoidsOutput() throws Exception {
        // Ellipsoids directory
        File ellDir = new File(mainDir+"/ellipsoids");
        if (!ellDir.exists()) {
            ellDir.mkdirs();
        } else {}
        nEllipOutput(ellDir);
    }
    private void ncubeOutput(File file) throws Exception {
        // Ncube data file & folder
        File hypercubeDir = new File(file+"/ncube");
        if (!hypercubeDir.exists()) {
            hypercubeDir.mkdirs();
        } else {}
        File ncubeFile = new File(hypercubeDir+"/ncubeData.tex");
        if (!ncubeFile.exists()) {
            ncubeFile.createNewFile();
        } else {}
        PrintStream out = new PrintStream(new FileOutputStream(ncubeFile), false);
        System.setOut(out);
        File ncubeImg = new File(hypercubeDir+"/ncubeImg");
        if (!ncubeImg.exists()) {
            ncubeImg.mkdirs();
        }
        // .tex file creation
        texFileTemp.texFileBeg("./ncubeImg/");
        // Title page
        texFileTemp.texFileTitle("N-Dimensional Cubes");
        // Info Page / Pages
        texFileTemp.texFileInfoPageNcube();
        // Data pages
        for (int i=0; i<dimNumMax; i++) {
            new NcubeOut(i, String.valueOf(ncubeImg));
        }
        System.out.println("\\end{document}");
    }
    private void nEllipOutput(File file) throws Exception {
        // Nell data file & folder
        File nsphereOut = new File(file+"/nEllipData.tex");
        if (!nsphereOut.exists()) {
            nsphereOut.createNewFile();
        }
        PrintStream out = new PrintStream(new FileOutputStream(nsphereOut), false);
        System.setOut(out);
        // .tex file creation
        texFileTemp.texFileBeg("");
        // Title page
        texFileTemp.texFileTitle("N-Dimensional Spheres \\& Ellipsoids");
        // Info Page / Pages
        texFileTemp.texFileInfoPageNsphere();
        // Data pages
        for (int i=1; i<dimNumMax; i++) {
            new NsphereEllOut(i, "");
        }
        System.out.println("\\end{document}");
    }
}

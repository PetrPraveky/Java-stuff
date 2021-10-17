package funcs.filesys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import funcs.filesys.tex.TexFileTemp;
import solids.platonic_solids.*;

//Function for creating folders and files with data
public class FolderCreate {
    File mainDir = new File(".output");
    TexFileTemp texFileTemp = new TexFileTemp();
    int dimNumMax = 21;
    public FolderCreate() throws Exception {
        // Main answer directory
        if (!mainDir.exists()) {
            mainDir.mkdirs();
        } else {}
        platonicSolidsOutputs();
    }
    private void platonicSolidsOutputs() throws Exception {
        // N-D rectangle directory
        File platDir = new File(mainDir+"/platonic_solids");
        if (!platDir.exists()) {
            platDir.mkdirs();
        } else {}
        ncubeOutput(platDir);
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
        // .tex file creation
        texFileTemp.texFileBeg();
        texFileTemp.texFileTitle("N-Dimensional cubes");
        for (int i=0; i<dimNumMax; i++) {
            new NcubeOut(i);
        }
        System.out.println("\\end{document}");
    }
}

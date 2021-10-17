package funcs.filesys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import solids.platonic_solids.*;

//Function for creating folders and files with data
public class FolderCreate {
    File mainDir = new File(".output");
    public FolderCreate() throws Exception {
        // Main answer directory
        if (!mainDir.exists()) {
            mainDir.mkdirs();
        } else {}
        platonicSolidsOutputs();
    }
    private void platonicSolidsOutputs() throws Exception {
        int dimNumMax = 51;
        // N-D rectangle directory
        File platDir = new File(mainDir+"/platonic_solids");
        if (!platDir.exists()) {
            platDir.mkdirs();
        } else {}
        ncubeOutput(platDir, dimNumMax);
    }
    private void ncubeOutput(File file, int num) throws Exception {
        File hypercubeDir = new File(file+"/ncube");
        if (!hypercubeDir.exists()) {
            hypercubeDir.mkdirs();
        } else {}
        // Ncube data file
        File ncubeFile = new File(hypercubeDir+"/ncubeData.txt");
        if (!ncubeFile.exists()) {
            ncubeFile.createNewFile();
        } else {}
        PrintStream out = new PrintStream(new FileOutputStream(ncubeFile), false);
        System.setOut(out);
        for (int i=0; i<num; i++) {
            new Ncube(i);
        }
    }
}

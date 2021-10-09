package funcs;

import funcs.platonic_solids.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
//Function for creating folders and files with data
public class AnsFolder {
    File mainDir = new File(".output");
    public AnsFolder() throws Exception {
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
        // File mainFile = new File(platDir+"/ncubeData.txt");
        // if (!mainFile.exists()) {
        //     mainFile.createNewFile();
        // } else {}
        // PrintStream mainOut = new PrintStream(new FileOutputStream(mainFile), false);
        // System.setOut(mainOut);
        // for (int j=0; j<dimNumMax; j++) {
        //     new AnsFile(j);
        // }
        // ---------------
        // Hypercube directory
        File hypercubeDir = new File(platDir+"/ncube");
        if (!hypercubeDir.exists()) {
            hypercubeDir.mkdirs();
        } else {}
        // Hypercube data file
        File ncubeFile = new File(hypercubeDir+"/ncubeData.txt");
        if (!ncubeFile.exists()) {
            ncubeFile.createNewFile();
        } else {}
        PrintStream out = new PrintStream(new FileOutputStream(ncubeFile), false);
        System.setOut(out);
        for (int i=0; i<dimNumMax; i++) {
            new Ncube(i);
        }
        // ---------------
    }
}

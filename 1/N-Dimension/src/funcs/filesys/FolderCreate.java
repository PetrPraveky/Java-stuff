package funcs.filesys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import funcs.filesys.tex.TexFile;
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
        var docClass = new TexFile("documentclass", "article");
        var beginDoc = new TexFile("begin", "document");
        var endDoc = new TexFile("end", "document");
        docClass.addOption("11pt").addOption("a4paper");
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
        System.out.println(docClass);
        System.out.println(beginDoc);
        for (int i=0; i<num; i++) {
            new Ncube(i);
        }
        System.out.println(endDoc);
    }
}

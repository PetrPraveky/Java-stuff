package funcs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
//Function for creating folders and files with data
public class AnsFolder {
    File mainDir = new File("output");
    public AnsFolder() throws Exception {
        // Main answer directory
        if (!mainDir.exists()) {
            mainDir.mkdirs();
        } else {}
        rectangleOutputs();
    }
    private void rectangleOutputs() throws Exception {
        // N-D rectangle directory
        File rectangleDir = new File(mainDir+"/rectangles");
        if (!rectangleDir.exists()) {
            rectangleDir.mkdirs();
        } else {}
        // ---------------
        // Hypercube directory
        File hypercubeDir = new File(rectangleDir+"/hypercube");
        if (!hypercubeDir.exists()) {
            hypercubeDir.mkdirs();
        } else {}
        // Hypercube data file
        File file = new File(hypercubeDir+"/hypercubeData.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {}
        PrintStream out = new PrintStream(new FileOutputStream(file), false);
        System.setOut(out);
        int dimNumMax = 21;
        for (int i=0; i<dimNumMax; i++) {
            new Nrectangle(i);
        }
        // ---------------
    }
}

package solids.platonic_solids;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;

import funcs.filesys.tex.TexCommands;
import solids.platonic_solids.ncube.NcubeAlgs;
// Class for hypercubes in n-dimensions
public class NcubeOut {
    public NcubeOut(int dimension) throws IOException {
        NcubeAlgs nCubeAlgs = new NcubeAlgs();
        TexCommands texCommands = new TexCommands();
        BigInteger vertNum = new BigInteger(nCubeAlgs.vertices(Integer.toString(dimension)));
        BigInteger edgNum = new BigInteger(nCubeAlgs.edges(Integer.toString(dimension)));
        BigInteger faceNum = new BigInteger(nCubeAlgs.faces(Integer.toString(dimension)));
        BigInteger cellNum = new BigInteger(nCubeAlgs.cells(Integer.toString(dimension)));
        texCommands.texTitleOneNCubeCommand(dimension);
        // Data
        texCommands.texMiddleLine(1);
        texCommands.texTitleDataNCubeCommand(dimension);
        texCommands.tex2ColumnDataNCubeCommand(String.valueOf(vertNum), "Vertices");
        texCommands.tex2ColumnDataNCubeCommand(String.valueOf(edgNum), "Edges");
        texCommands.tex2ColumnDataNCubeCommand(String.valueOf(faceNum), "Faces");
        texCommands.tex2ColumnDataNCubeCommand(String.valueOf(cellNum), "Cells");
        texCommands.texMiddleLine(0.2);
        // Geometric values
        texCommands.texTitleValNCubeCommand(dimension);
        if (dimension != 0) {
            if (dimension == 1) {
                System.out.println("\\textbf{");
                texCommands.tex2Surface(dimension, 0, "");
                System.out.println("}");
                texCommands.tex2Surface(dimension, 1, " for lenght $a = 1$");
                texCommands.tex2Surface(dimension, 2, " for lenght $a = 2$");                
            } else {
                // Volume
                System.out.println("\\textbf{");
                texCommands.tex2Volume(dimension, 0, "");
                System.out.println("}");
                texCommands.tex2Volume(dimension, 1, " for side lenght $a = 1$");
                texCommands.tex2Volume(dimension, 2, " for side length $a = 2$");
                texCommands.texMiddleLine(0.2);
                // Surface
                System.out.println("\\textbf{");
                texCommands.tex2Surface(dimension, 0, "");
                System.out.println("}");
                texCommands.tex2Surface(dimension, 1, " for side lenght $a = 1$");
                texCommands.tex2Surface(dimension, 2, " for side lenght $a = 2$");
                texCommands.texMiddleLine(0.2);
                // Diagonal
                System.out.println("\\textbf{");
                texCommands.tex2DiagonalCommand(dimension, 0, "");
                System.out.println("}");
                texCommands.tex2DiagonalCommand(dimension, 1, " for side lenght $a = 1$");
                texCommands.tex2DiagonalCommand(dimension, 2, " for side lenght $a = 2$");
            }
        } else {
            System.out.println("\\begin{multicols}{2}");
            System.out.println("- None");
            System.out.println("\\end{multicols}");
        }
        if (dimension>1) {
            System.out.println("\\newpage");
        } else {
            texCommands.texMiddleLine(0.2);
        }
        System.out.println("\\null\\textbf{Graph for "+dimension+" cube:}");
        System.out.println("\\newpage");
    }
    public void NcubeGraphOut() throws IOException {
        int width = 300;
        int height = 300;
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = buffImg.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0,0,width,height);
        g2d.setColor(Color.black);
        g2d.fillOval(0,0,width,height);
        g2d.setColor(Color.ORANGE);
        g2d.drawString("Saad Yoursuf", 55, 125);
        g2d.dispose();
        File file = new File("saadImg.png");
        ImageIO.write(buffImg, "png", file);
    }
}
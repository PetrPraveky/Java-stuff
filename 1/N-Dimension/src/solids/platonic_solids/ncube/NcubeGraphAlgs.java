package solids.platonic_solids.ncube;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;

import funcs.math.MathFuncs;
// Algoritm for printing out graph/visualization of n-dimensional cube
public class NcubeGraphAlgs {
    MathFuncs mathFuncs = new MathFuncs();
    List<List<List<List<Integer>>>> twoDSegment = new ArrayList<>();
    List<List<List<Integer>>> oneDSegment = new ArrayList<>();
    List<List<Integer>> zeroDSegment = new ArrayList<>();
    List<Integer> pointAxis = new ArrayList<Integer>();
    int sideLenght = 50;
    
    public NcubeGraphAlgs(String folder, int dimension) throws IOException {
        // WritePoints(dimension);
        WritePoint(dimension);
        System.out.println("\n"+twoDSegment);
        System.out.println("\n"+twoDSegment.size());
        System.out.println("\n"+twoDSegment.get(0));
        System.out.println("\n"+twoDSegment.get(0).get(0));
        System.out.println("\n"+twoDSegment.get(0).get(0).get(0));
        System.out.println("\n"+twoDSegment.get(0).get(0).get(0).get(0));
        PrintPoints(dimension, folder);
    }
    private void PrintPoints(int dimension, String folder) throws IOException {
        int width = 1000;
        int height = 1000;
        BufferedImage outImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = outImg.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        // Random rand = new Random();
        int x = 0;
        for (int i = 0; i < twoDSegment.size(); i++) {
            if (i%8==0 && i!=0) {
                x++;
                System.out.println(x);
            }
            for (int j = 0; j < (twoDSegment.get(i)).size(); j++) {
                // 1D
                for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                    g2d.drawLine(twoDSegment.get(i).get(j).get(0).get(0), twoDSegment.get(i).get(j).get(0).get(1), twoDSegment.get(i).get(j).get(1).get(0), twoDSegment.get(i).get(j).get(1).get(1));
                }
                // 2D
                for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                    try {
                        g2d.drawLine(twoDSegment.get(i).get(j+k).get(k).get(0), twoDSegment.get(i).get(j+k).get(k).get(1), twoDSegment.get(i).get(j+1-k).get(k).get(0), twoDSegment.get(i).get(j+1-k).get(k).get(1));
                    } catch (Exception e) {}
                }
                // 3D
                for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                    try {
                        g2d.drawLine(twoDSegment.get(i*2).get(j).get(0+k).get(0), twoDSegment.get(i*2).get(j).get(0+k).get(1), twoDSegment.get((i*2)+1).get(j).get(0+k).get(0), twoDSegment.get((i*2)+1).get(j).get(0+k).get(1));
                    } catch (Exception e) {}
                }
                // 4D
                if (i%4==0 || (i-1)%4==0) {
                    for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                        try {
                            g2d.drawLine(twoDSegment.get(i).get(j).get(0+k).get(0), twoDSegment.get(i).get(j).get(0+k).get(1), twoDSegment.get(i+2).get(j).get(0+k).get(0), twoDSegment.get(i+2).get(j).get(0+k).get(1));
                        } catch (Exception e) {}
                    }                
                }
                // 5D
                g2d.setColor(Color.red);
                if (i >= 0+(8*x) && i < 4+(8*x)) {
                    for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                        try {
                            g2d.drawLine(twoDSegment.get(i).get(j).get(0+k).get(0), twoDSegment.get(i).get(j).get(0+k).get(1), twoDSegment.get(i+4).get(j).get(0+k).get(0), twoDSegment.get(i+4).get(j).get(0+k).get(1));
                        } catch (Exception e) {}
                    }                
                }
                g2d.setColor(Color.black);
            }
        }
        File file = new File(folder+"saadImg.png");
        // File file = new File(folder+"saadImg"+(dimension)+".png");
        ImageIO.write(outImg, "png", file);     
    }
    // Create virtual points
    private void WritePoint(int dimension) {
        int baseX = 300; int baseY = 300;
        int pastI = 0;
        if (dimension <2) {
            for (int k = 0; k<(dimension+1); k++) {
                pointAxis.add(baseX+k*sideLenght);
                pointAxis.add(baseY);
                zeroDSegment.add(new ArrayList<Integer>(pointAxis));
                oneDSegment.add(new ArrayList<>(zeroDSegment));
                twoDSegment.add(new ArrayList<>(oneDSegment));
                pointAxis.clear();
                zeroDSegment.clear();
                oneDSegment.clear();
            }
        } else {
            for (int i = 0; i<(mathFuncs.power(2, (dimension-2))); i++) {
                if (pastI%16 == 0 && pastI !=0) {
                    baseX = baseX-325;
                    baseY = baseY+25;                   
                }
                else if (pastI%8 == 0 && pastI != 0) {
                    baseX = baseX+100;
                    baseY = baseY-25;
                }
                else if (pastI%4 == 0 && pastI != 0) {
                    baseX = baseX-150;
                    baseY = baseY+100;
                }
                else if (pastI%2 == 0 && pastI != 0) {
                    baseX = baseX+60;
                    baseY = baseY+60;                    
                }
                else if (pastI%2 != 0) {
                    baseX = baseX+25;
                    baseY = baseY-25;
                }
                Point2DPart(baseX, baseY);
                twoDSegment.add(new ArrayList<>(oneDSegment));
                oneDSegment.clear();
                pastI ++;
            }
        }
    } 
    // Position of points in 2D
    private void Point2DPart(int baseX, int baseY) {
        for (int i = 0; i<2; i++) {
            baseY = baseY+i*sideLenght;
            for (int j = 0; j<2; j++) {
                pointAxis.add(baseX+j*sideLenght);
                pointAxis.add(baseY);
                zeroDSegment.add(new ArrayList<Integer>(pointAxis));
                pointAxis.clear();
            } 
            oneDSegment.add(new ArrayList<>(zeroDSegment));
            zeroDSegment.clear();
        }
    }
}
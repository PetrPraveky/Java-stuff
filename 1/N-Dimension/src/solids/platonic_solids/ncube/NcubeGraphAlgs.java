package solids.platonic_solids.ncube;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        System.out.println("\n"+twoDSegment.get(0));
        System.out.println("\n"+twoDSegment.get(0).get(0));
        System.out.println("\n"+twoDSegment.get(0).get(0).get(0));
        System.out.println("\n"+twoDSegment.get(0).get(0).get(0).get(0));
        System.out.println(twoDSegment.size());
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
        Random rand = new Random();
        for (int i = 0; i < twoDSegment.size(); i++) {
            // float r = rand.nextFloat();
            // float g = rand.nextFloat();
            // float b = rand.nextFloat();
            // Color randomColor = new Color(r, g, b);
            // g2d.setColor(randomColor);
            for (int j = 0; j < (twoDSegment.get(i)).size(); j++) {
                for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                    g2d.drawLine(twoDSegment.get(i).get(j).get(0).get(0), twoDSegment.get(i).get(j).get(0).get(1), twoDSegment.get(i).get(j).get(1).get(0), twoDSegment.get(i).get(j).get(1).get(1));
                }
                for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                    try {
                        g2d.drawLine(twoDSegment.get(i).get(j+k).get(k).get(0), twoDSegment.get(i).get(j+k).get(k).get(1), twoDSegment.get(i).get(j+1-k).get(k).get(0), twoDSegment.get(i).get(j+1-k).get(k).get(1));
                    } catch (Exception e) {}
                }
                for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                    try {
                        g2d.drawLine(twoDSegment.get(i*2).get(j).get(0+k).get(0), twoDSegment.get(i*2).get(j).get(0+k).get(1), twoDSegment.get((i*2)+1).get(j).get(0+k).get(0), twoDSegment.get((i*2)+1).get(j).get(0+k).get(1));
                    } catch (Exception e) {}
                }
                for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                    try {
                        g2d.drawLine(twoDSegment.get(i).get(j).get(0+k).get(0), twoDSegment.get(i).get(j).get(0+k).get(1), twoDSegment.get(i+2).get(j).get(0+k).get(0), twoDSegment.get(i+2).get(j).get(0+k).get(1));
                    } catch (Exception e) {}
                }                
            }
        }
        File file = new File(folder+"saadImg"+(dimension-1)+".png");
        ImageIO.write(outImg, "png", file);     
    }
    // Create virtual points
    private void WritePoint(int dimension) {
        int baseX = 200; int baseY = 200;
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
                System.out.println(pastI);
                if (pastI%2 == 0 && pastI != 0) {
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
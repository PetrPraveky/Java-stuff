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
    int minX = 10000; int maxX = 0;
    int minY = 10000; int maxY = 0;
    int sizeCoefX = 0; int sizeCoefY = 0;
    
    public NcubeGraphAlgs(String folder, int dimension) throws IOException {
        if (dimension < 16) {
            WritePoint(dimension);
            PrintPoints(dimension, folder);
        }
    }
    private void PrintPoints(int dimension, String folder) throws IOException {
        int width = maxX-minX+20; int height = maxY-minY+20;
        int sizeCoefX = minX-10; int sizeCoefY = minY-10;
        BufferedImage outImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = outImg.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        // Random rand = new Random();
        List<Integer> x = new ArrayList<>();
        int x1 = 0; int x2 = 0; int x3 = 0; int x4 = 0; int x5 = 0; int x6 = 0; int x7 = 0; int x8 = 0;
        int x9 = 0; int x10 = 0; int x11 = 0; int x12 = 0; int x13 = 0; int x14 = 0; int x15 = 0; int x16 = 0;    
        if (dimension>1) {
            for (int i = 0; i < twoDSegment.size(); i++) {
                x.clear();
                if (i%8==0 && i!=0) {
                    x1++;
                }
                if (i%16==0 && i!=0) {
                    x2++;
                }
                if (i%32==0 && i!=0) {
                    x3++;
                }
                if (i%64==0 && i!=0) {
                    x4++;
                }
                if (i%128==0 && i!=0) {
                    x5++;
                }
                if (i%256==0 && i!=0) {
                    x6++;
                }
                if (i%512==0 && i!=0) {
                    x7++;
                }
                if (i%1024==0 && i!=0) {
                    x8++;
                }
                if (i%2048==0 && i!=0) {
                    x9++;
                }
                if (i%4096==0 && i!=0) {
                    x10++;
                }
                if (i%8192==0 && i!=0) {
                    x11++;
                }
                if (i%16384==0 && i!=0) {
                    x12++;
                }
                if (i%32768==0 && i!=0) {
                    x13++;
                }
                if (i%65536==0 && i!=0) {
                    x14++;
                }
                if (i%131072==0 && i!=0) {
                    x15++;
                }
                if (i%262144==0 && i!=0) {
                    x16++;
                }
                x.add(x1); x.add(x2); x.add(x3); x.add(x4); x.add(x5); x.add(x6); x.add(x7); x.add(x8);
                x.add(x9); x.add(x10); x.add(x11); x.add(x12); x.add(x13); x.add(x14); x.add(x15); x.add(x16);
                for (int j = 0; j < (twoDSegment.get(i)).size(); j++) {
                    // 1D
                    for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                        g2d.drawLine(
                            twoDSegment.get(i).get(j).get(0).get(0)-sizeCoefX, 
                            twoDSegment.get(i).get(j).get(0).get(1)-sizeCoefY, 
                            twoDSegment.get(i).get(j).get(1).get(0)-sizeCoefX, 
                            twoDSegment.get(i).get(j).get(1).get(1)-sizeCoefY
                            );
                    }
                    // 2D
                    for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                        try {
                            g2d.drawLine(
                                twoDSegment.get(i).get(j+k).get(k).get(0)-sizeCoefX, 
                                twoDSegment.get(i).get(j+k).get(k).get(1)-sizeCoefY, 
                                twoDSegment.get(i).get(j+1-k).get(k).get(0)-sizeCoefX, 
                                twoDSegment.get(i).get(j+1-k).get(k).get(1)-sizeCoefY
                                );
                        } catch (Exception e) {}
                    }
                    // 3D
                    for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                        try {
                            g2d.drawLine(
                                twoDSegment.get(i*2).get(j).get(0+k).get(0)-sizeCoefX, 
                                twoDSegment.get(i*2).get(j).get(0+k).get(1)-sizeCoefY, 
                                twoDSegment.get((i*2)+1).get(j).get(0+k).get(0)-sizeCoefX, 
                                twoDSegment.get((i*2)+1).get(j).get(0+k).get(1)-sizeCoefY
                                );
                        } catch (Exception e) {}
                    }
                    // 4D
                    if (i%4==0 || (i-1)%4==0) {
                        for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                            try {
                                g2d.drawLine(
                                    twoDSegment.get(i).get(j).get(0+k).get(0)-sizeCoefX, 
                                    twoDSegment.get(i).get(j).get(0+k).get(1)-sizeCoefY, 
                                    twoDSegment.get(i+2).get(j).get(0+k).get(0)-sizeCoefX, 
                                    twoDSegment.get(i+2).get(j).get(0+k).get(1)-sizeCoefY
                                    );
                            } catch (Exception e) {}
                        }                
                    }
                    // // 5D
                    for (int l = 2; l<(dimension-1); l++) {
                        int coef1 = (int)mathFuncs.power(2, (l+1)); // dim 5 == 8
                        int coef2 = (int)mathFuncs.power(2, (l)); // dim 5 == 4
                        if (i >= 0+(coef1*(x.get(l-2))) && i < coef2+(coef1*(x.get(l-2)))) {
                            for (int k = 0; k < (twoDSegment.get(i).get(j)).size(); k++) {
                                try {
                                    g2d.drawLine(
                                        twoDSegment.get(i).get(j).get(0+k).get(0)-sizeCoefX, 
                                        twoDSegment.get(i).get(j).get(0+k).get(1)-sizeCoefY, 
                                        twoDSegment.get(i+coef2).get(j).get(0+k).get(0)-sizeCoefX, 
                                        twoDSegment.get(i+coef2).get(j).get(0+k).get(1)-sizeCoefY
                                        );
                                } catch (Exception e) {}
                            }                
                        }                        
                    }
                    g2d.setColor(Color.red);
                    g2d.setColor(Color.black);
                }
            }
            // File file = new File(folder+"saadImg.png");
            File file = new File(folder+"/"+(dimension)+"DcubeImg.png");
            ImageIO.write(outImg, "png", file);     
        } else {
            if (dimension==1) {
                g2d.drawLine(
                    twoDSegment.get(0).get(0).get(0).get(0)-sizeCoefX, 
                    twoDSegment.get(0).get(0).get(0).get(1)-sizeCoefY, 
                    twoDSegment.get(1).get(0).get(0).get(0)-sizeCoefX, 
                    twoDSegment.get(1).get(0).get(0).get(1)-sizeCoefY
                    );
                File file = new File(folder+"/"+(dimension)+"DcubeImg.png");
                ImageIO.write(outImg, "png", file);                    
            } else {}
        }
    }
    // Create virtual points
    private void WritePoint(int dimension) {
        int baseX = 300; int baseY = 100;
        int pastI = 0;
        if (dimension <2) {
            for (int k = 0; k<(dimension+1); k++) {
                pointAxis.add(baseX+k*sideLenght);
                if (baseX+k*sideLenght>maxX) {
                    maxX = baseX+k*sideLenght;
                }
                if (baseX+k*sideLenght<minX) {
                    minX = baseX+k*sideLenght;
                }
                pointAxis.add(baseY);
                if (baseY>maxY) {
                    maxY = baseY;
                }
                if (baseY<minY) {
                    minY = baseY;
                }
                zeroDSegment.add(new ArrayList<Integer>(pointAxis));
                oneDSegment.add(new ArrayList<>(zeroDSegment));
                twoDSegment.add(new ArrayList<>(oneDSegment));
                pointAxis.clear();
                zeroDSegment.clear();
                oneDSegment.clear();
            }
        } else {
            for (int i = 0; i<(mathFuncs.power(2, (dimension-2))); i++) {
                //19D
                if (pastI%65536 == 0 && pastI != 0) {
                    baseX = baseX+-30000;
                    baseY = baseY-5000;   
                }
                //18D
                else if (pastI%32768 == 0 && pastI != 0) {
                    baseX = baseX+7000;
                    baseY = baseY-25000;   
                }
                //17D
                else if (pastI%16384 == 0 && pastI != 0) {
                    baseX = baseX-20000;
                    baseY = baseY-2500;   
                }
                //16D
                else if (pastI%8192 == 0 && pastI != 0) {
                    baseX = baseX+3500;
                    baseY = baseY-12000;   
                }
                //15D
                else if (pastI%4096 == 0 && pastI != 0) {
                    baseX = baseX-9000;
                    baseY = baseY-500;   
                }
                //14D
                else if (pastI%2048 == 0 && pastI != 0) {
                    baseX = baseX+250;
                    baseY = baseY-4500;   
                }
                //13D
                else if (pastI%1024 == 0 && pastI != 0) {
                    baseX = baseX-2500;
                    baseY = baseY+100;   
                }
                //12D
                else if (pastI%512 == 0 && pastI != 0) {
                    baseX = baseX+500;
                    baseY = baseY-2300;   
                }
                //11D
                else if (pastI%256 == 0 && pastI != 0) {
                    baseX = baseX-1500;
                    baseY = baseY+100;   
                }
                //10D
                else if (pastI%128 == 0 && pastI != 0) {
                    baseX = baseX+300;
                    baseY = baseY-1000;   
                }
                //9D
                else if (pastI%64 == 0 && pastI != 0) {
                    baseX = baseX-500;
                    baseY = baseY+100;   
                }
                //8D                
                else if (pastI%32 == 0 && pastI != 0) {
                    baseX = baseX+225;
                    baseY = baseY-400;    
                }
                //7D
                else if (pastI%16 == 0 && pastI !=0) {
                    baseX = baseX-325;
                    baseY = baseY+25;                   
                }
                //6D
                else if (pastI%8 == 0 && pastI != 0) {
                    baseX = baseX+100;
                    baseY = baseY-25;
                }
                //5D
                else if (pastI%4 == 0 && pastI != 0) {
                    baseX = baseX-150;
                    baseY = baseY+100;
                }
                //4D
                else if (pastI%2 == 0 && pastI != 0) {
                    baseX = baseX+60;
                    baseY = baseY+60;                    
                }
                //3D
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
            if (baseY>maxY) {
                maxY = baseY;
            }
            if (baseY<minY) {
                minY = baseY;
            }
            for (int j = 0; j<2; j++) {
                pointAxis.add(baseX+j*sideLenght);
                if (baseX+j*sideLenght>maxX) {
                    maxX = baseX+j*sideLenght;
                }
                if (baseX+j*sideLenght<minX) {
                    minX = baseX+j*sideLenght;
                }
                pointAxis.add(baseY);
                zeroDSegment.add(new ArrayList<Integer>(pointAxis));
                pointAxis.clear();
            } 
            oneDSegment.add(new ArrayList<>(zeroDSegment));
            zeroDSegment.clear();
        }
    }
}
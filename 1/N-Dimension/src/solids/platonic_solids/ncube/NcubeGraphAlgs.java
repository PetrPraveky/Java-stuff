package solids.platonic_solids.ncube;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.DomainCombiner;
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
    public NcubeGraphAlgs(String folder, int dimension) {
        WritePoints(dimension);
    }
    // Create virtual points
    private void WritePoints(int dimension) {
        int baseX = 50; int baseY = 50;
        if (dimension != 0) {
            for (int i = 0; i<(mathFuncs.power(2, (dimension-1))); i++) {
                Point2DPart(baseX, baseY);
                twoDSegment.add(new ArrayList<>(oneDSegment));
                oneDSegment.clear();
            }
        } else {

        }
        System.out.println("\n"+twoDSegment);

    }
    private void Point2DPart(int baseX, int baseY) {
        for (int i = 0; i<2; i++) {
            baseY = baseY+i*sideLenght;
            Point1DPart(baseX, baseY);
            oneDSegment.add(new ArrayList<>(zeroDSegment));
            zeroDSegment.clear();
        }
    }
    private void Point1DPart(int baseX, int baseY) {
        for (int i = 0; i<2; i++) {
            pointAxis.add(baseX+i*sideLenght);
            pointAxis.add(baseY);
            // System.out.println(pointAxis);
            zeroDSegment.add(new ArrayList<Integer>(pointAxis));
            pointAxis.clear();
        }       
    }
}

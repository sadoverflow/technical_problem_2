package main_code.java;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class Performance {

    public static void main(String[] args) throws IOException {
        int[] szs = {1000, 5000, 10000, 50000, 100000};
        XYSeries ser = new XYSeries("Execution Time");

        for (int sz : szs) {
            int[] num = genNums(sz);
            long st = System.nanoTime();
            Numbers._sum(num);
            long et = System.nanoTime();
            long dur = et - st;
            ser.add(sz, dur);
        }

        XYSeriesCollection dset = new XYSeriesCollection(ser);
        JFreeChart cht = ChartFactory.createXYLineChart(
                "Test",
                "Amount of Elements",
                "Execution Time",
                dset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plt = cht.getXYPlot();
        XYLineAndShapeRenderer rndr = new XYLineAndShapeRenderer();
        rndr.setSeriesLinesVisible(0, true);
        rndr.setSeriesShapesVisible(0, false);
        plt.setRenderer(rndr);

        JFrame frm = new JFrame("Performance");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().add(new ChartPanel(cht));
        frm.pack();
        frm.setVisible(true);
    }

    private static int[] genNums(int sz) {
        Random rnd = new Random();
        int[] nums = new int[sz];
        for (int i = 0; i < sz; i++) {
            nums[i] = rnd.nextInt(1000);
        }
        return nums;
    }
}

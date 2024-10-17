package com.uniquindio;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;

public class Graficador {
    public static void mostrarGrafica(Map<String, Double> tiempos, String archivo, String titulo) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (Map.Entry<String, Double> entry : tiempos.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), archivo);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                titulo,
                "Algoritmo", "Tiempo (segundos)",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        JFrame ventana = new JFrame(titulo);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(chartPanel);
        ventana.pack();
        ventana.setVisible(true);
    }
}

package com.uniquindio;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Graficos extends JFrame {

    public Graficos(String titulo) {
        super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Función para crear un gráfico de barras para un arreglo y sus tiempos
    public void crearGrafico(String tituloGrafico, String[] metodos, double[] tiempos) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Añadir los datos al dataset
        for (int i = 0; i < metodos.length; i++) {
            dataset.addValue(tiempos[i], "Tiempo", metodos[i]); // Nombre del método debajo de la barra
        }

        // Crear el gráfico de barras
        JFreeChart barChart = ChartFactory.createBarChart(
                tituloGrafico,
                "Métodos de Ordenamiento", // Etiqueta del eje X
                "Tiempo (Segundos)",  // Etiqueta del eje Y
                dataset
        );

        // Obtener el plot para personalizar
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Mostrar los valores encima de las barras
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);  // Habilitar etiquetas visibles

        // Crear el panel y mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    // Método para mostrar las tres gráficas
    public static void generarGraficos(double[] tiempos10000, double[] tiempos100000, double[] tiempos1000000) {
        String[] metodos = {"Burbuja", "Quicksort", "Pigeonhole Sort", "Merge Sort", "Bitonic Sort"};

        // Gráfico para 10,000 elementos
        Graficos grafico10000 = new Graficos("Tiempos para 10,000 elementos");
        grafico10000.crearGrafico("Tiempos de Ordenamiento - 10,000 elementos", metodos, tiempos10000);
        grafico10000.pack();
        grafico10000.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla
        grafico10000.setVisible(true);

        // Gráfico para 100,000 elementos
        Graficos grafico100000 = new Graficos("Tiempos para 100,000 elementos");
        grafico100000.crearGrafico("Tiempos de Ordenamiento - 100,000 elementos", metodos, tiempos100000);
        grafico100000.pack();
        grafico100000.setLocationRelativeTo(null);
        grafico100000.setVisible(true);

        // Gráfico para 1,000,000 elementos
        Graficos grafico1000000 = new Graficos("Tiempos para 1,000,000 elementos");
        grafico1000000.crearGrafico("Tiempos de Ordenamiento - 1,000,000 elementos", metodos, tiempos1000000);
        grafico1000000.pack();
        grafico1000000.setLocationRelativeTo(null);
        grafico1000000.setVisible(true);
    }
}

package com.uniquindio;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("\tInicio de ordemaniento");
        // Crear archivos de números aleatorios si no existen
        ArchivoUtils.crearArchivo("Arreglo 10.000", 10000);
        ArchivoUtils.crearArchivo("Arreglo 100.000", 100000);
        ArchivoUtils.crearArchivo("Arreglo 1.000.000", 1000000);

        // Leer archivos y aplicar los algoritmos
        int[] arr10k = leerArchivo("Archivos/Arreglo 10.000.txt", 10000);
        int[] arr100k = leerArchivo("Archivos/Arreglo 100.000.txt", 100000);
        int[] arr1M = leerArchivo("Archivos/Arreglo 1.000.000.txt", 1000000);

        // Mapas para almacenar los tiempos de cada algoritmo
        Map<String, Double> tiempos10k = new HashMap<>();
        Map<String, Double> tiempos100k = new HashMap<>();
        Map<String, Double> tiempos1M = new HashMap<>();

        // Ejecutar los algoritmos de ordenamiento y medir el tiempo
        long start, end;

        // Burbuja
        System.out.println("Metodo Burbuja");
        start = System.nanoTime();
        Ordenamiento.burbuja(arr10k.clone());
        end = System.nanoTime();
        tiempos10k.put("Burbuja", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.burbuja(arr100k.clone());
        end = System.nanoTime();
        tiempos100k.put("Burbuja", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.burbuja(arr1M.clone());
        end = System.nanoTime();
        tiempos1M.put("Burbuja", (end - start) / 1e9);

        // Quicksort
        start = System.nanoTime();
        Ordenamiento.quicksort(arr10k.clone(), 0, arr10k.length - 1);
        end = System.nanoTime();
        tiempos10k.put("Quicksort", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.quicksort(arr100k.clone(), 0, arr100k.length - 1);
        end = System.nanoTime();
        tiempos100k.put("Quicksort", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.quicksort(arr1M.clone(), 0, arr1M.length - 1);
        end = System.nanoTime();
        tiempos1M.put("Quicksort", (end - start) / 1e9);


        // stoogeSort
        start = System.nanoTime();
        Ordenamiento.stoogeSort(arr10k.clone(), 0, arr10k.length - 1);
        end = System.nanoTime();
        tiempos10k.put("StoogeSort", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.stoogeSort(arr100k.clone(), 0, arr100k.length - 1);
        end = System.nanoTime();
        tiempos100k.put("StoogeSort", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.stoogeSort(arr1M.clone(), 0, arr1M.length - 1);
        end = System.nanoTime();
        tiempos1M.put("StoogeSort", (end - start) / 1e9);

        // pigeonholeSort
        start = System.nanoTime();
        Ordenamiento.pigeonholeSort(arr10k.clone());
        end = System.nanoTime();
        tiempos10k.put("Burbuja", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.pigeonholeSort(arr100k.clone());
        end = System.nanoTime();
        tiempos100k.put("Burbuja", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.pigeonholeSort(arr1M.clone());
        end = System.nanoTime();
        tiempos1M.put("Burbuja", (end - start) / 1e9);

        // Merge Sort
        start = System.nanoTime();
        Ordenamiento.mergeSort(arr10k.clone(), 0, arr10k.length - 1);
        end = System.nanoTime();
        tiempos10k.put("Merge Sort", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.mergeSort(arr100k.clone(), 0, arr100k.length - 1);
        end = System.nanoTime();
        tiempos100k.put("Merge Sort", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.mergeSort(arr1M.clone(), 0, arr1M.length - 1);
        end = System.nanoTime();
        tiempos1M.put("Merge Sort", (end - start) / 1e9);


        // Bitonic Sort
        start = System.nanoTime();
        Ordenamiento.bitonicSort(arr10k.clone(), 0, arr10k.length - 1,true);
        end = System.nanoTime();
        tiempos10k.put("Bitonic Sort", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.mergeSort(arr100k.clone(), 0, arr100k.length - 1);
        end = System.nanoTime();
        tiempos100k.put("Bitonic Sort", (end - start) / 1e9);

        start = System.nanoTime();
        Ordenamiento.mergeSort(arr1M.clone(), 0, arr1M.length - 1);
        end = System.nanoTime();
        tiempos1M.put("Bitonic Sort", (end - start) / 1e9);




        // Otros algoritmos... seguir el mismo patrón para Stooge, Pigeonhole, Merge, etc.

        // Mostrar las gráficas
        Graficador.mostrarGrafica(tiempos10k, "10.000 elementos", "Tiempos de Ordenamiento (10.000 elementos)");
        Graficador.mostrarGrafica(tiempos100k, "100.000 elementos", "Tiempos de Ordenamiento (100.000 elementos)");
        Graficador.mostrarGrafica(tiempos1M, "1.000.000 elementos", "Tiempos de Ordenamiento (1.000.000 elementos)");
    }

    // Método para leer el archivo y cargar el arreglo
    public static int[] leerArchivo(String ruta, int size) throws IOException {
        int[] arr = new int[size];
        BufferedReader reader = new BufferedReader(new FileReader(ruta));
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null && i < size) {
            arr[i] = Integer.parseInt(line.trim());
            i++;
        }
        reader.close();
        return arr;
    }
}

package com.uniquindio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("\tInicio de ordenamiento");
        // Crear archivos de números aleatorios si no existen
        ArchivoUtils.crearArchivo("Arreglo 10.000", 10000);
        ArchivoUtils.crearArchivo("Arreglo 100.000", 100000);
        ArchivoUtils.crearArchivo("Arreglo 1.000.000", 1000000);

        // Leer archivos y aplicar los algoritmos
        int[] arr10k = leerArchivo("Archivos/Arreglo 10.000.txt", 10000);
        int[] arr100k = leerArchivo("Archivos/Arreglo 100.000.txt", 100000);
        int[] arr1M = leerArchivo("Archivos/Arreglo 1.000.000.txt", 1000000);

        // Arrays para almacenar los tiempos de cada algoritmo
        double[] tiempos10k = new double[6];
        double[] tiempos100k = new double[6];
        double[] tiempos1M = new double[6];

        long start, end;
        int algoritmoIndex = 0;


         // Burbuja Sort
    System.out.println("Ejecución método Burbuja");
    start = System.nanoTime();
    Ordenamiento.burbuja(arr10k.clone());
    end = System.nanoTime();
    tiempos10k[algoritmoIndex] = (end - start)/1000000000.0;

    start = System.nanoTime();
    Ordenamiento.burbuja(arr100k.clone());
    end = System.nanoTime();
    tiempos100k[algoritmoIndex] = (end - start)/1000000000.0;

    start = System.nanoTime();
    Ordenamiento.burbuja(arr1M.clone());
    end = System.nanoTime();
    tiempos1M[algoritmoIndex] = (end - start)/1000000000.0;
    algoritmoIndex++;

    // Quicksort
    System.out.println("Ejecución método Quicksort");
    start = System.nanoTime();
    Ordenamiento.quicksort(arr10k.clone(), 0, arr10k.length - 1);
    end = System.nanoTime();
    tiempos10k[algoritmoIndex] = (end - start)/1000000000.0;

    start = System.nanoTime();
    Ordenamiento.quicksort(arr100k.clone(), 0, arr100k.length - 1);
    end = System.nanoTime();
    tiempos100k[algoritmoIndex] = (end - start)/1000000000.0;

    start = System.nanoTime();
    Ordenamiento.quicksort(arr1M.clone(), 0, arr1M.length - 1);
    end = System.nanoTime();
    tiempos1M[algoritmoIndex] = (end - start)/1000000000.0;
    algoritmoIndex++;


        // Stooge Sort
        /* 
        System.out.println("Ejecución método Stooge Sort");
        start = System.nanoTime();
        Ordenamiento.stoogeSort(arr10k.clone(), 0, arr10k.length - 1);
        end = System.nanoTime();
        tiempos10k[algoritmoIndex] = end - start;

        start = System.nanoTime();
        Ordenamiento.stoogeSort(arr100k.clone(), 0, arr100k.length - 1);
        end = System.nanoTime();
        tiempos100k[algoritmoIndex] = end - start;

        start = System.nanoTime();
        Ordenamiento.stoogeSort(arr1M.clone(), 0, arr1M.length - 1);
        end = System.nanoTime();
        tiempos1M[algoritmoIndex] = end - start;

        algoritmoIndex++;*/

        // Pigeonhole Sort
        System.out.println("Ejecución método Pigeonhole Sort");
        start = System.nanoTime();
        Ordenamiento.pigeonholeSort(arr10k.clone());
        end = System.nanoTime();
        tiempos10k[algoritmoIndex] = (end - start)/1000000000.0;

        start = System.nanoTime();
        Ordenamiento.pigeonholeSort(arr100k.clone());
        end = System.nanoTime();
        tiempos100k[algoritmoIndex] = (end - start)/1000000000.0;

        start = System.nanoTime();
        Ordenamiento.pigeonholeSort(arr1M.clone());
        end = System.nanoTime();
        tiempos1M[algoritmoIndex] = (end - start)/1000000000.0;

        algoritmoIndex++;

        // Merge Sort
        System.out.println("Ejecución método Merge Sort");
        start = System.nanoTime();
        Ordenamiento.mergeSort(arr10k.clone(), 0, arr10k.length - 1);
        end = System.nanoTime();
        tiempos10k[algoritmoIndex] = (end - start)/1000000000.0;

        start = System.nanoTime();
        Ordenamiento.mergeSort(arr100k.clone(), 0, arr100k.length - 1);
        end = System.nanoTime();
        tiempos100k[algoritmoIndex] = (end - start)/1000000000.0;

        start = System.nanoTime();
        Ordenamiento.mergeSort(arr1M.clone(), 0, arr1M.length - 1);
        end = System.nanoTime();
        tiempos1M[algoritmoIndex] = (end - start)/1000000000.0;

        algoritmoIndex++;

        // Bitonic Sort
        System.out.println("Ejecución método Bitonic Sort");
        start = System.nanoTime();
        Ordenamiento.bitonicSort(arr10k.clone(), 0, arr10k.length, true);
        end = System.nanoTime();
        tiempos10k[algoritmoIndex] = (end - start)/1000000000.0;

        start = System.nanoTime();
        Ordenamiento.bitonicSort(arr100k.clone(), 0, arr100k.length, true);
        end = System.nanoTime();
        tiempos100k[algoritmoIndex] = (end - start)/1000000000.0;

        start = System.nanoTime();
        Ordenamiento.bitonicSort(arr1M.clone(), 0, arr1M.length, true);
        end = System.nanoTime();
        tiempos1M[algoritmoIndex] = (end - start)/1000000000.0;

        // Generar las gráficas con los tiempos obtenidos
        Graficos.generarGraficos(tiempos10k, tiempos100k, tiempos1M);
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

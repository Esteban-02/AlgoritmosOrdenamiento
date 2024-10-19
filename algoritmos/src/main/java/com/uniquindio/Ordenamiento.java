package com.uniquindio;

import java.util.Arrays;

public class Ordenamiento {
    // Método Burbuja
    public static void burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Método Quicksort
    public static void quicksort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    // Método para Stooge Sort
    public static void stoogeSort(int[] arr, int l, int h) {
        
        if (l >= h) {
            return;
        }

        if (arr[l] > arr[h]) {
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
        }

        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
            stoogeSort(arr, l, h - t);
            stoogeSort(arr, l + t, h);
            stoogeSort(arr, l, h - t);
        }
    }

    // Método para Pigeonhole Sort
    public static void pigeonholeSort(int[] arr) {
        
        int min = arr[0], max = arr[0], range, i, j, index;

        for (int a : arr) {
            if (a > max) max = a;
            if (a < min) min = a;
        }

        range = max - min + 1;
        int[] pigeonhole = new int[range];

        Arrays.fill(pigeonhole, 0);

        for (i = 0; i < arr.length; i++) {
            pigeonhole[arr[i] - min]++;
        }

        index = 0;
        for (j = 0; j < range; j++) {
            while (pigeonhole[j]-- > 0) {
                arr[index++] = j + min;
            }
        }
    }

    // Método para Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Método para Bitonic Sort
    public static void bitonicSort(int[] arr, int low, int cnt, boolean dir) {
        
        if (cnt > 1) {
            int k = cnt / 2;
            bitonicSort(arr, low, k, true);
            bitonicSort(arr, low + k, k, false);
            bitonicMerge(arr, low, cnt, dir);
        }
    }

    private static void bitonicMerge(int[] arr, int low, int cnt, boolean dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                if (dir == (arr[i] > arr[i + k])) {
                    int temp = arr[i];
                    arr[i] = arr[i + k];
                    arr[i + k] = temp;
                }
            }
            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low + k, k, dir);
        }
    }


}

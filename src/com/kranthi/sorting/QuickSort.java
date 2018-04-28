package com.kranthi.sorting;

public class QuickSort {
    // "static void main" must be defined in a public class.


    public static void qSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            qSort(arr, lo, p - 1);
            qSort(arr, p + 1, hi);
        }
    }

    public static void swap(int[] arr, int first, int second) {

        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo - 1;

        for (int j = lo; j <= hi-1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, hi);

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {34, 65, 23, 7, 345, 974, 235, 835, 32};
        qSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.printf("%5d", i);
        }

    }

}

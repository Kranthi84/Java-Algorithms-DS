package com.kranthi.sorting;

import java.util.Arrays;
import java.util.Random;

public class C_Prob11_1 {

    public static Integer[] mergeSortedArrays(Integer[] a, Integer[] b, int sizeA, int sizeB) {

        int lastIndex_A = sizeA - 1;
        int lastIndex_B = sizeB - 1;
        int mergeIndex = sizeA + sizeB - 1;

        while (lastIndex_A >= 0 && lastIndex_B >= 0) {
            if (a[lastIndex_A] > b[lastIndex_B]) {
                a[mergeIndex] = a[lastIndex_A];
                mergeIndex--;
                lastIndex_A--;
            } else {
                a[mergeIndex] = b[lastIndex_B];
                mergeIndex--;
                lastIndex_B--;
            }

        }

        while (lastIndex_B >= 0) {
            a[mergeIndex] = b[lastIndex_B];
            mergeIndex--;
            lastIndex_B--;
        }
        return a;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        Integer[] b = new Integer[5];
        for (int i = 0; i < a.length; i++) {
            if (i < 4)
                a[i] = new Random().nextInt(100);
            else
                a[i] = 0;

        }
        Arrays.sort(a);
        for (int j = 0; j < b.length; j++) {
            b[j] = new Random().nextInt(100);
        }
        Arrays.sort(b);

        Integer[] mergeArray = mergeSortedArrays(a, b, 4, 5);

        for (int m : mergeArray) {
            System.out.printf("%5d", m);
        }
    }
}

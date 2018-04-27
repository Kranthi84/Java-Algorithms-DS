package com.kranthi.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob14_2 {

    public static List<Integer> mergeSortedArrays(List<Integer> first, int m, List<Integer> second, int n) {

        int a = m - 1, b = n - 1, mrgIndex = m + n - 1;

        while (a >= 0 && b >= 0) {
            first.set(mrgIndex--, first.get(a) > second.get(b) ? first.get(a--) : second.get(b--));
        }
        while (b >= 0) {
            first.set(mrgIndex--, second.get(b--));
        }

        return first;
    }

    public static void main(String[] args) {

        Integer[] firstArray = {3, 5, 6, 9, 0, 0, 0, 0, 0, 0, 0}, secondArray = {2, 4, 10, 14, 21};
        List<Integer> mergedArray = mergeSortedArrays(Arrays.asList(firstArray), 4, Arrays.asList(secondArray), 5);
        for (int a : mergedArray) {
            System.out.printf("%4d", a);
        }

    }
}

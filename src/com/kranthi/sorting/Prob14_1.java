package com.kranthi.sorting;

import java.util.*;

public class Prob14_1 {


    public static List<Integer> intersectionOfTwoEqualArrays(List<Integer> first, List<Integer> second) {
        int i = 0, j = 0;

        List<Integer> intersectionFirstSecond = new ArrayList<>();
        while (i < first.size() && j < second.size()) {
            if ((i == 0 || first.get(i) != first.get(i - 1)) && (first.get(i) == second.get(j))) {
                intersectionFirstSecond.add(first.get(i));
                ++i;
                ++j;
            } else if (first.get(i) < second.get(j)) {
                ++i;
            } else {
                ++j;
            }
        }

        return intersectionFirstSecond;
    }


    // Using minimum size list as an iterator and searching the value in second list using binary search, as the lists are sorted.
    // Running time: O(m log n) -> m is length of smaller array and log n is for looking the item in the sorted second list.


    public static List<Integer> intersectionOfTwoArraysUsingBinarySearch(List<Integer> first, List<Integer> second) {
        ArrayList<Integer> intersectionFirstSecond = new ArrayList<>();
        for (int i = 0; i < first.size(); ++i) {
            if ((i == 0 || first.get(i) != first.get(i - 1)) && Collections.binarySearch(second, first.get(i)) >= 0) {
                intersectionFirstSecond.add(first.get(i));
            }
        }

        return intersectionFirstSecond;
    }
    // Brute force - O(n2)

    public static List<Integer> intersectionOfTwoArrays(List<Integer> first, List<Integer> second) {

        ArrayList<Integer> intersectionFirstSecond = new ArrayList<>();
        for (int i = 0; i < first.size(); ++i) {


            if (i == 0 || (first.get(i) != first.get(i - 1))) {

                for (int b : second) {
                    if (first.get(i) == b) {
                        intersectionFirstSecond.add(b);
                        break;
                    }
                }

            }
        }
        return intersectionFirstSecond;
    }

    public static void main(String[] args) {
        // write your code here

        Scanner mScan = new Scanner(System.in);

        int firstLength = mScan.nextInt();
        int secondLength = mScan.nextInt();
        Integer[] firstList = new Integer[firstLength];
        Integer[] secondList = new Integer[secondLength];

        for (int i = 0; i < firstLength; i++) {
            firstList[i] = mScan.nextInt();
        }

        for (int j = 0; j < secondLength; j++) {
            secondList[j] = mScan.nextInt();
        }

        mScan.close();

        // Only Equal lists
        List<Integer> mEqualList = intersectionOfTwoEqualArrays(Arrays.asList(firstList), Arrays.asList(secondList));

        for (int a : mEqualList) {
            System.out.printf("%2d", a);
        }

        /*List<Integer> mIntList = intersectionOfTwoArrays(Arrays.asList(firstList), Arrays.asList(secondList));

        List<Integer> mIntListBinary = intersectionOfTwoArraysUsingBinarySearch(Arrays.asList(firstList), Arrays.asList(secondList));


        for (int a : mIntList) {
            System.out.printf("%3d", a);
        }
        System.out.println();
        for (int a : mIntListBinary) {
            System.out.printf("%3d", a);
        }*/

    }
}

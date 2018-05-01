package com.kranthi.sorting;

public class C_Prob11_3 {

    public static int findItemPosition(int[] array, int left, int right, int x) {

        int mid = (left + right) / 2;
        if (array[mid] == x) {
            return mid;
        }

        if (left > right) {
            return -1;
        }

        if (array[left] < array[mid]) {
            if (x >= array[left] && x <= array[mid])
                return findItemPosition(array, left, mid - 1, x);
            else
                return findItemPosition(array, mid + 1, right, x);
        } else if (array[left] > array[mid]) {
            if (x >= array[mid] && x <= array[right])
                return findItemPosition(array, mid + 1, right, x);
            else
                return findItemPosition(array, left, mid - 1, x);
        } else if (array[left] == array[mid]) {
            if (array[mid] != array[right]) {
                return findItemPosition(array, mid + 1, right, x);
            } else {
                int result = findItemPosition(array, left, mid - 1, x);
                if (result == -1) {
                    result = findItemPosition(array, mid + 1, right, x);
                }
                return result;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        int[] mArray_1 = {10, 15, 20, 0, 5};
        int[] mArray_2 = {50, 5, 20, 30, 40};
        int[] mArray_3 = {2, 2, 2, 3, 4, 2};
        System.out.printf("%2d", findItemPosition(mArray_3, 0, 5, 2));
    }

}

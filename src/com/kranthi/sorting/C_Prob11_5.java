package com.kranthi.sorting;

public class C_Prob11_5 {

    public static int searchR(String[] mStrings, String sStr, int first, int last) {

        if (first < last) {
            return -1;
        }

        int mid = (first + last) / 2;

        if (mStrings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;

            while (true) {
                if (left < first && right > last) {
                    return -1;
                }
                if (left >= first && !mStrings[left].isEmpty()) {
                    mid = left;
                    break;
                }

                if (right <= last && !mStrings[right].isEmpty()) {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }


        if (mStrings[mid].compareTo(sStr) < 0) {
            return searchR(mStrings, sStr, mid + 1, last);
        } else if (mStrings[mid].compareTo(sStr) > 0) {
            return searchR(mStrings, sStr, first, mid - 1);
        } else {
            return mid;
        }


    }


    public static int searchStrings(String[] sStrings, String searchString) {
        if (sStrings == null || sStrings.length == 0 || searchString.isEmpty()) {
            return -1;
        }
        return searchR(sStrings, searchString, 0, searchString.length() - 1);
    }


    public static void main(String[] args) {

    }
}

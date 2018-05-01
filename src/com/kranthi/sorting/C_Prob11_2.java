package com.kranthi.sorting;

import java.util.*;

public class C_Prob11_2 implements Comparator<String> {

    static String sortChars(String mString) {
        char[] sChars = mString.toCharArray();
        Arrays.sort(sChars);
        return new String(sChars);
    }

    @Override
    public int compare(String o1, String o2) {
        return sortChars(o1).compareTo(sortChars(o2));
    }

    public static String[] sort(String[] sArray) {
        HashMap<String, LinkedList<String>> mapAnagram = new HashMap<>();
        for (String s : sArray) {
            String key = sortChars(s);
            if (!mapAnagram.containsKey(key)) {
                mapAnagram.put(key, new LinkedList<>());
            }
            LinkedList<String> anagrams = mapAnagram.get(key);
            anagrams.push(s);
        }

        int index = 0;
        for (String key : mapAnagram.keySet()) {
            for (String sWord : mapAnagram.get(key)) {
                sArray[index] = sWord;
                index++;
            }
        }

        return sArray;
    }

    public static void main(String[] args) {
        String[] mStringArray = {"care", "rag", "car", "cat", "acre", "boy", "race", "top", "mop", "pot"};
        String[] anagram_array = sort(mStringArray);
        for (String s : anagram_array) {
            System.out.printf("%5s", s);
        }
    }

}

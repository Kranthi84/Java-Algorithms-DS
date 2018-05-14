package com.kranthi.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class C_Prob11_7 {

    public static ArrayList<HtWt> getLogSequence(ArrayList<HtWt> items) {
        Collections.sort(items);
        return longestSubSequence(items);
    }

    public static void longestSubSequence(ArrayList<HtWt> array, ArrayList<HtWt>[] solutions, int curr_index) {
        if (curr_index < 0 || curr_index >= array.size())
            return;
        HtWt mCurrentElement = array.get(curr_index);

        ArrayList<HtWt> mBigSequence = null;
        for (int i = 0; i < curr_index; i++) {
            if (array.get(i).isBefore(mCurrentElement)) {
                mBigSequence = seqWithMaxLength(mBigSequence, solutions[i]);
            }
        }
        ArrayList<HtWt> newSolution = new ArrayList<>();
        if (mBigSequence != null) {
            newSolution.addAll(mBigSequence);
        }
        newSolution.add(mCurrentElement);
        solutions[curr_index] = newSolution;

        longestSubSequence(array, solutions, curr_index + 1);
    }

    public static ArrayList<HtWt> longestSubSequence(ArrayList<HtWt> items) {
        ArrayList<HtWt>[] mSolutions = new ArrayList[items.size()];

        longestSubSequence(items, mSolutions, 0);

        ArrayList<HtWt> mBigSequence = null;

        for (int i = 0; i < items.size(); i++) {

            mBigSequence = seqWithMaxLength(mBigSequence, mSolutions[i]);
        }

        return mBigSequence;

    }

    public static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
        if (seq1 == null)
            return seq2;
        else if (seq2 == null)
            return seq1;
        else
            return seq1.size() < seq2.size() ? seq2 : seq1;
    }


    public static void main(String[] args) {

        HtWt p1 = new HtWt(34.0, 45.0);
        HtWt p2 = new HtWt(12.0, 36.0);
        HtWt p3 = new HtWt(58.0, 14.0);
        HtWt p4 = new HtWt(96.0, 256.0);

        ArrayList<HtWt> listHtWt = new ArrayList<>();
        listHtWt.add(p1);
        listHtWt.add(p2);
        listHtWt.add(p3);
        listHtWt.add(p4);

        ArrayList<HtWt> mLongSequence = getLogSequence(listHtWt);

        for (HtWt mHW : mLongSequence) {
            System.out.println(mHW);
        }
    }

    // Inner class for Collections and Sorting

    static class HtWt implements Comparable<HtWt> {

        public double mHt, mWt;

        HtWt(double mHt, double mWt) {
            this.mHt = mHt;
            this.mWt = mWt;
        }

        @Override
        public int compareTo(HtWt o) {

            if (this.mHt != o.mHt) {
                return ((Double) this.mHt).compareTo(o.mHt);
            } else
                return ((Double) this.mWt).compareTo(o.mWt);
        }

        public boolean isBefore(HtWt element) {
            if (this.mHt < element.mHt && this.mWt < element.mWt)
                return true;
            else
                return false;
        }

        @Override
        public String toString() {
            return "HtWt{" +
                    "mHt=" + mHt +
                    ", mWt=" + mWt +
                    '}';
        }
    }
}

package com.kranthi.sorting;

public class C_Prob11_8 {

    static class Node {
        int mData = 0;
        Node left, right;
        int left_size = 0;

        Node(int data) {
            this.mData = data;
        }

        void insert(int num) {

            if (num <= mData) {
                if (left != null) {
                    left.insert(num);
                    left_size++;
                } else {
                    left = new Node(num);
                }
            } else {
                if (right != null) {
                    right.insert(num);
                } else
                    right = new Node(num);
            }

        }

        int getRank(int num) {
            if (num == mData) {
                return left_size;
            }
            if (num < mData) {
                if (left == null)
                    return -1;
                else
                    return left.getRank(num);
            } else {
                int right_rank = right == null ? -1 : right.getRank(num);
                if (right_rank == -1)
                    return -1;
                else
                    return left_size + 1 + right_rank;
            }
        }
    }

    static class Finder {
        Node mRoot = null;

        void track(int num) {
            if (mRoot == null) {
                mRoot = new Node(num);
            } else {
                mRoot.insert(num);
            }
        }

        int getRankNumber(int num) {
            if (mRoot == null) {
                return 0;
            } else {
                return mRoot.getRank(num);
            }
        }
    }

    public static void main(String[] args) {

        int[] inputArray = {5, 1, 4, 4, 5, 9, 7, 13, 3};
        Finder mFinder = new Finder();
        for (int i : inputArray) {
            mFinder.track(i);
        }

        int rank_1 = mFinder.getRankNumber(13);
        int rank_2 = mFinder.getRankNumber(4);
        int rank_3 = mFinder.getRankNumber(5);
        System.out.print(rank_1 + " " + rank_2 + " " + rank_3);
    }
}

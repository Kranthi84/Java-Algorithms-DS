package com.kranthi.sorting;

public class C_Prob4_3 {


    public static void main(String[] args) {

    }

    static class TreeNode {
        TreeNode mLeft, mRight;
        int data;

        TreeNode(int d) {
            this.data = d;
        }
    }

    static TreeNode createBST(int[] array, int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.mLeft = createBST(array, start, mid - 1);
        root.mRight = createBST(array, mid + 1, end);
        return root;
    }

    static TreeNode createMinimalBST(int[] array) {
        return createBST(array, 0, array.length - 1);
    }
}

package com.kranthi.sorting;

public class C_Prob4_1 {

    static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.mLeft), getHeight(root.mRight)) + 1;
    }


    public static void main(String[] args) {

    }


    class TreeNode {
        TreeNode mLeft, mRight;
        int mData;


        TreeNode(int data) {
            this.mData = data;
        }
    }
}

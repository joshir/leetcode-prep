package com.joshir.tree.bst;

public class SplitBST {
  class Solution {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
    }
    public TreeNode[] splitBST(TreeNode root, int value) {
      if (root == null)
        return new TreeNode[]{null, null};
      else if (root.val <= value) {
        TreeNode[] bst = splitBST(root.right, value);
        root.right = bst[0];
        bst[0] = root;
        return bst;
      } else {
        TreeNode[] bns = splitBST(root.left, value);
        root.left = bns[1];
        bns[1] = root;
        return bns;
      }
    }
  }
}

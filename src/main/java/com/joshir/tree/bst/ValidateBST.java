package com.joshir.tree.bst;

public class ValidateBST {
  class Solution {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
        val = x;
      }
    }

    public boolean validate(TreeNode root, Integer low, Integer high) {
      if (root == null)
        return true;
      if ((low != null && root.val <= low) || (high != null && root.val >= high))
        return false;

      return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBST(TreeNode root) {
      return validate(root, null, null);
    }
  }
}

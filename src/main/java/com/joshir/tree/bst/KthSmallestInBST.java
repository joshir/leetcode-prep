package com.joshir.tree.bst;

import java.util.ArrayList;

public class KthSmallestInBST {
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
    public ArrayList<Integer> dfs(TreeNode root, ArrayList<Integer> arr) {
      if (root == null) return arr;
      dfs(root.left, arr);
      arr.add(root.val);
      dfs(root.right, arr);
      return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
      ArrayList<Integer> nums = dfs(root, new ArrayList<Integer>());
      return nums.get(k - 1);
    }
  }
}

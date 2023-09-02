package com.joshir.tree.bst;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV {
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
    public boolean findTarget(TreeNode root, int k) {
      List<Integer> list = new ArrayList();
      inorder(root, list);
      int l = 0, r = list.size() - 1;
      while (l < r) {
        int sum = list.get(l) + list.get(r);
        if (sum == k)
          return true;
        if (sum < k)
          l++;
        else
          r--;
      }
      return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
      if (root == null)
        return;
      inorder(root.left, list);
      list.add(root.val);
      inorder(root.right, list);
    }
  }
}

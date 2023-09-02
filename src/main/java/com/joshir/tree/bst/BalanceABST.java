package com.joshir.tree.bst;

import java.util.ArrayList;
import java.util.List;

public class BalanceABST {
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

    private static void toInorder(TreeNode root, List<Integer> path) {
      if(root==null)
        return;

      toInorder(root.left, path);
      path.add(root.val);
      toInorder(root.right, path);
    }

    private TreeNode constructBST(List<Integer> inOrderTraversal, int start, int end) {
      if(start > end)
        return null;
      int mid = start + (end-start)/2;

      TreeNode root = new TreeNode(inOrderTraversal.get(mid));
      root.left = constructBST(inOrderTraversal, start, mid-1);
      root.right = constructBST(inOrderTraversal, mid+1, end);
      return root;
    }

    public TreeNode balanceBST(TreeNode root) {
      if(root==null)
        return null;

      List<Integer> inOrderTraversal = new ArrayList<>();
      toInorder(root, inOrderTraversal);
      return constructBST(inOrderTraversal, 0, inOrderTraversal.size()-1);
    }
  }
}

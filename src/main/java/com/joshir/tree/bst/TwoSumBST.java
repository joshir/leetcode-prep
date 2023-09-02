package com.joshir.tree.bst;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {
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
    private void dfs(TreeNode currNode, Set<Integer> nodeSet) {
      if (currNode == null)
        return;

      dfs(currNode.left, nodeSet);
      nodeSet.add(currNode.val);
      dfs(currNode.right, nodeSet);
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
      Set<Integer> n1 = new HashSet<>();
      Set<Integer> n2 = new HashSet<>();

      dfs(root1, n1);
      dfs(root2, n2);

      for (int value1 : n1) {
        if (n2.contains(target - value1)) {
          return true;
        }
      }

      return false;
    }
  }
}

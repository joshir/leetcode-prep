package com.joshir.tree.bst;

import java.util.Arrays;
import java.util.HashMap;

public class BSTFromPreOrderTraversal {
  class Solution {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left,  TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
    }
    int index = 0;
    int[] preorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
      if (in_left == in_right)
        return null;

      int root_val = preorder[index];
      TreeNode root = new TreeNode(root_val);
      int index = idx_map.get(root_val);
      this.index++;
      root.left = helper(in_left, index);
      root.right = helper(index + 1, in_right);
      return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
      this.preorder = preorder;
      int [] inorder = Arrays.copyOf(preorder, preorder.length);
      Arrays.sort(inorder);

      int idx = 0;
      for (Integer val : inorder)
        idx_map.put(val, idx++);
      return helper(0, inorder.length);
    }
  }
}

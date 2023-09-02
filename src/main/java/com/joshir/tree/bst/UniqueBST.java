package com.joshir.tree.bst;

public class UniqueBST {
  public class Solution {
    public int numTrees(int k) {
      int[] n = new int[k + 1];
      n[0] = 1;
      n[1] = 1;

      for (int i = 2; i <= k; ++i) {
        for (int j = 1; j <= i; ++j) {
          n[i] += n[j - 1] * n[i - j];
        }
      }
      return n[k];
    }
  }
}

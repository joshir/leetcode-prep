package com.joshir.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
  class Solution {
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> ans = new ArrayList<>();
      backtrack(new ArrayList<>(), 1, ans, n, k);
      return ans;
    }

    public void backtrack(List<Integer> curr, int i, List<List<Integer>> ans, int n, int k) {
      if (curr.size() == k) {
        ans.add(new ArrayList<>(curr));
        return;
      }

      for (int num = i; num <= n; num++) {
        curr.add(num);
        backtrack(curr, num + 1, ans, n, k);
        curr.remove(curr.size() - 1);
      }
    }
  }
}

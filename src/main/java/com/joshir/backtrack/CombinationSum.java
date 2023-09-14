package com.joshir.backtrack;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  class Solutions {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      backtrack(candidates, new ArrayDeque<Integer>(), target, 0);
      return res;
    }

    private void backtrack(int [] candidates, ArrayDeque<Integer> cur, int index, int target) {
      if(target == 0) {
        res.add(cur.stream().toList());
        return;
      }
      if(index == candidates.length || target < 0)
        return;

      for (int i = index; i < candidates.length; i++) {
       cur.addLast(candidates[i]);
       backtrack(candidates, cur, index+1, target - candidates[i]);
       cur.removeLast();
      }
    }
  }
}

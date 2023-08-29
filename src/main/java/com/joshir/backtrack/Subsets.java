package com.joshir.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      backtrack(new ArrayList<>(), 0, ans, nums);
      return ans;
    }

    public void backtrack(List<Integer> curr, int i, List<List<Integer>> ans, int[] nums) {
      if (i > nums.length) {
        return;
      }

      ans.add(new ArrayList<>(curr));
      for (int j = i; j < nums.length; j++) {
        curr.add(nums[j]);
        backtrack(curr, j + 1, ans, nums);
        curr.remove(curr.size() - 1);
      }
    }

  public static void main(String[] args) {
    List<List<Integer>> arr = new Subsets().subsets(new int [] {1,2,3});

    arr.forEach(a -> {
      a.forEach(integer -> System.out.print(integer+" "));
      System.out.println();
    });
  }
}

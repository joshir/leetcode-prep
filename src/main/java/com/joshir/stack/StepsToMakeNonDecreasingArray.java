package com.joshir.stack;

import java.util.Stack;

public class StepsToMakeNonDecreasingArray {
  class Solution {
    public int totalSteps(int[] nums) {
      Stack<int[]> stack = new Stack<>();
      int count = 0, ans = 0;
      stack.push(new int [] {nums[nums.length - 1], 0});

      for(int i = nums.length - 2 ; i >= 0; i--) {
        count = 0;

        // count is supposed to count the longest chain of pops
        // with nums[i] and is equivalent to the number of steps
        // required because the longest chain dictates the number of steps.
        while(!stack.isEmpty() && stack.peek()[0]  < nums[i]) {
          count = Math.max(count+1, stack.peek()[1]);
          stack.pop();
        }
        ans = Math.max(ans, count);
        stack.push(new int[] {nums[i], count});
      }
      return ans;
    }
  }
}

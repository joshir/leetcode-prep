package com.joshir.dynamic;

import java.util.Arrays;

public class HouseRobberI {
  class Solution {
    private static int [] cache = new int [100];
    public int rob(int[] nums) {
      if(nums == null) return 0;
      Arrays.fill(cache, -1);
      return rob(nums, 0);
    }

    public int rob(int[] nums, int index) {
      if(index >= nums.length) return 0;
      // if it's already in the cache, blah blah
      if(cache[index] > -1) return cache[index];

      // not in the cache so go ahead and call both variants and return the max
      cache[index] = Math.max(nums[index] + rob(nums, index+2), rob(nums, index+1));
      return cache[index];
    }
  }


  // editorial
  class SolutionDP {
    public int rob(int[] nums) {
      int N = nums.length;

      // Special handling for empty array case.
      if (N == 0) {
        return 0;
      }

      int[] dp = new int[nums.length + 1];

      // Base case initializations.
      dp[N] = 0;
      dp[N - 1] = nums[N - 1];

      // DP table calculations.
      for (int i = N - 2; i >= 0; --i) {

        // Same as the recursive solution.
        dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
      }
      return dp[0];
    }
  }


  // editorial
  class SolutionWithDPWithSpaceOptimization {

    public int rob(int[] nums) {
      int N = nums.length;

      if (N == 0) {
        return 0;
      }

      int robNext, robNextPlusOne;

      // Base case initializations.
      robNextPlusOne = 0;
      robNext= nums[N - 1];

      // DP table calculations. Note: we are not using any
      // table here for storing values. Just using two
      // variables will suffice.
      for (int i = N - 2; i >= 0; --i) {

        // Same as the recursive solution.
        int current = Math.max(robNext, robNextPlusOne + nums[i]);

        // Update the variables
        robNextPlusOne = robNext;
        robNext = current;
      }
      return robNext;
    }
  }
}

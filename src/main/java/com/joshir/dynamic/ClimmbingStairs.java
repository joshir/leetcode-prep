package com.joshir.dynamic;

import java.util.Arrays;

public class ClimmbingStairs {
  // TLE
  class SolutionTopDown {
    public int climbStairs(int n) {
      int cache[] = new int[n+1];
      Arrays.fill(cache, -1);
      return dp(cache, n);
    }

    public int  dp(int[] cache, int n) {
      if (n <= 2) return n;

      if(cache[n]!=-1) return cache[n];

      cache[n] = climbStairs(n-1) + climbStairs(n-2);
      return cache[n];
    }
  }

  class SolutionBottomUpSpaceOptimized {
    public int climbStairs(int n) {
      if (n <= 2) return n;

      int first = 1, second = 2, sum = 0;
      for (int i = 3; i<=n ; i++){
        sum = (first + second);
        first = second;
        second = sum;
      }
      return sum;
    }
  }
}

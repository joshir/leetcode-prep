package com.joshir.dynamic;

import java.util.Arrays;

public class MinCostClimbingStairs {
  class TopDown{
    private int[] cache;
    public int minCostClimbingStairs(int[] cost) {
      cache = new int[cost.length];
      Arrays.fill(cache, -1);
      return Math.min(minCostClimbingStairs(cost, cache,cost.length-1), minCostClimbingStairs(cost, cache,cost.length-2));
    }
    private int minCostClimbingStairs(int[] cost, int[] cache,int n) {
      if (n < 0) return 0;
      else if (n==0 || n==1) return cost[n];

      if (cache[n] != 0) return cache[n];

      cache[n] = cost[n] + Math.min(minCostClimbingStairs(cost, cache,n-1), minCostClimbingStairs(cost, cache,n-2));
      return cache[n];
    }
  }

  class BottomUp{
    public int minCostClimbingStairs(int[] cost) {
      if (cost.length <= 2) return Math.min(cost[0], cost[1]);

      int first = cost[0], second = cost[1];
      for (int i=2; i < cost.length ; i++) {
        int curr = cost[i] + Math.min(first, second);
        first = second;
        second = curr;
      }
      return Math.min(first, second);
    }
  }
}

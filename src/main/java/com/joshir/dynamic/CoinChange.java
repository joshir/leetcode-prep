package com.joshir.dynamic;

import java.util.Arrays;

public class CoinChange {
  class TopdownMemoized{
    public int coinChange(int[] coins, int amount) {
      if (amount < 1) return 0;
      return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int remaining, int[] count) {
      if (remaining < 0) return -1;
      if (remaining == 0) return 0;
      if (count[remaining - 1] != 0) return count[remaining - 1];

      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        int res = coinChange(coins, remaining - coin, count);
        if (res >= 0 && res < min)
          min = 1 + res;
      }

      count[remaining - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
      return count[remaining - 1];
    }
  }

  public class SolutionBottomUp {
    public int coinChange(int[] coins, int amount) {
      int max = amount + 1;
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, max);
      dp[0] = 0;
      for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
          if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          }
        }
      }
      return dp[amount] > amount ? -1 : dp[amount];
    }
  }
}

package com.joshir.dynamic;

public class EditDistance {

  class SolutionTopDown {
    Integer cache[][];

    public int minDistance(String word1, String word2) {
      int m = word1.length(), n = word2.length();
      cache = new Integer[word1.length() + 1][word2.length() + 1];
      return minDistance(word1, word2, m, n);
    }

    int minDistance(String word1, String word2, int i, int j) {
      if (i == 0) {
        return j;
      }
      if (j == 0) {
        return i;
      }
      if (cache[i][j] != null) {
        return cache[i][j];
      }
      int minEditDistance = 0;
      if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        minEditDistance = minDistance(word1, word2, i - 1, j - 1);
      }
      else {
        int insertOperation = minDistance(word1, word2, i, j - 1);
        int deleteOperation = minDistance(word1, word2, i - 1, j);
        int replaceOperation = minDistance(word1, word2, i - 1, j - 1);
        minEditDistance = Math.min(insertOperation, Math.min(deleteOperation, replaceOperation)) + 1;
      }
      cache[i][j] = minEditDistance;
      return minEditDistance;
    }
  }

  class SolutionBU {
    public int minDistance(String word1, String word2) {
      int m = word1.length(), n = word2.length();

      // dp[i][j] := min # of operations to convert word1[0..i) to word2[0..j)
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; ++i)
        dp[i][0] = i;

      for (int j = 1; j <= n; ++j)
        dp[0][j] = j;

      for (int i = 1; i <= m; ++i)
        for (int j = 1; j <= n; ++j)
          if (word1.charAt(i - 1) == word2.charAt(j - 1))
            dp[i][j] = dp[i - 1][j - 1];
          else
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

      return dp[m][n];
    }
  }
}

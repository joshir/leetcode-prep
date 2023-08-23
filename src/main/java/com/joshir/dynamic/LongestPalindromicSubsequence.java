package com.joshir.dynamic;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
  class SolutionBruteForce {
    public int longestPalindromeSubseq(char[] s,  int i, int j) {
      if (i > j) return 0;
      else if (i == j) return 1;
      // pointees are equal so increase length by 2 since they're going to be counted in the final subsequence
      if (s[i] == s[j]) return longestPalindromeSubseq(s, i + 1, j - 1) + 2;
      // otherwise move one forward, one backward and choose the one that gives the longer palindromic subsequence
      else return Math.max(longestPalindromeSubseq(s, i + 1, j), longestPalindromeSubseq(s, i, j - 1));
    }

    public int longestPalindromeSubseq(String s) {
      return longestPalindromeSubseq(s.toCharArray(), 0, s.length() - 1);
    }
  }

  class SolutionDPTopDown {
    public int longestPalindromeSubseq(char[] s, int[][] cache, int i, int j) {
      if (i > j) return 0;
      if (i == j) return 1;
      if(cache[i][j] != 0 ) return cache[i][j];

      if (s[i] == s[j])
        cache[i][j] = longestPalindromeSubseq(s, cache,i + 1, j - 1) + 2;
      else
        cache[i][j] = Math.max(longestPalindromeSubseq(s, cache, i + 1, j), longestPalindromeSubseq(s, cache, i, j - 1));

      return cache[i][j];
    }

    public int longestPalindromeSubseq(String s) {
      int n = s.length();
      int [][] cache = new int[n][n];
      return longestPalindromeSubseq(s.toCharArray(), cache, 0, n - 1);
    }
  }

  class SolutionDPBottomUp {
    public int longestPalindromeSubseq(String s) {
      int[][] dp = new int[s.length()][s.length()];

      for (int i = s.length() - 1; i >= 0; i--) {
        dp[i][i] = 1;  // diagonal along dp table where char i=j and therefore s[i]==s[j] sp len = 1
        // sum upwards from the diagonal
        for (int j = i + 1; j < s.length(); j++) {
          if (s.charAt(i) == s.charAt(j))
            dp[i][j] = dp[i + 1][j - 1] + 2;
          else
            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
      return dp[0][s.length() - 1];
    }
  }

  class SolutionDPSpaceOptimized{
    public int longestPalindromeSubseq(String s) {
      int n = s.length();
      int[] dp = new int[n];
      int[] dpPrev = new int[n];

      for (int i = n - 1; i >= 0; --i) {
        dp[i] = 1;
        for (int j = i + 1; j < n; ++j) {
          if (s.charAt(i) == s.charAt(j))
            dp[j] = dpPrev[j - 1] + 2;
          else
            dp[j] = Math.max(dpPrev[j], dp[j - 1]);
        }
        dpPrev = dp.clone();
      }
      return dp[n - 1];
    }
  }
}
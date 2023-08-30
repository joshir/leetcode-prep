package com.joshir.dynamic;

import java.util.Arrays;

public class LongestPalindromicSubsequenceII {
  public class SolutionTopDown {
    private int[][][] cache ;
    public int longestPalindromeSubseq(String s) {
      cache = new int[s.length()][s.length()][27];
      for (int r = 0; r < cache.length; r++)
        for (int c = 0; c < cache[r].length; c++)
          Arrays.fill(cache[r][c], -1);
      return longestPalindromeSubseq(0, s.length() - 1, 26, s);
    }

    private int longestPalindromeSubseq(int i, int j, int prev, String s) {
      if (i >= j)
        return 0;
      if (cache[i][j][prev] != -1)
        return cache[i][j][prev];

      if (s.charAt(i) - 'a' == prev)
        return cache[i][j][prev] = longestPalindromeSubseq(i + 1, j, prev, s);
      if (s.charAt(j) - 'a' == prev)
        return cache[i][j][prev] = longestPalindromeSubseq(i, j - 1, prev, s);

      if (s.charAt(i) == s.charAt(j))
        cache[i][j][prev] = longestPalindromeSubseq(i + 1, j - 1, s.charAt(i) - 'a', s) + 2;
      else {
        cache[i][j][prev] = Math.max(
          longestPalindromeSubseq(i + 1, j, prev, s),
          longestPalindromeSubseq(i, j - 1, prev, s)
        );
      }
      return cache[i][j][prev];
    }
  }


  public class SolutionBottomUp {
    public int longestPalindromeSubseq(String s) {
      int[][][] cache = new int[s.length()][s.length()][27];
      for (int i = s.length() - 1; i >= 0; i--) {
        for (int j = 0; j < s.length(); j++) {
          for (int prev = 0; prev <= 26; prev++) {

            if (i >= j)
              continue;

            if (s.charAt(i) - 'a' == prev) {
              cache[i][j][prev] = cache[i + 1][j][prev];
              continue;
            }

            if (s.charAt(j) - 'a' == prev) {
              cache[i][j][prev] = cache[i][j - 1][prev];
              continue;
            }

            if (s.charAt(i) == s.charAt(j))
              cache[i][j][prev] = cache[i + 1][j - 1][s.charAt(i) - 'a'] + 2;
            else {
              cache[i][j][prev] =  Math.max(
                cache[i + 1][j][prev],
                cache[i][j - 1][prev]
              );
            }
          }
        }
      }
      return cache[0][s.length() - 1][26];
    }
  }
}

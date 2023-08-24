package com.joshir.dynamic;

import java.util.Arrays;

public class ValidPalindromeIII {
  class Bruteforce{

    // TLE
    public int isValidPalindrome(char[] s, int i, int j) {
      if (i == j) return 0; // base case for c1
      if (j-i == 1) return s[i] != s[j] ? 1 : 0; // base case for c2

      if(s[i] == s[j])
        return isValidPalindrome(s, i+1, j-1); // c1
      else
        return 1 + Math.min(isValidPalindrome(s, i+1,j), isValidPalindrome(s,i,j - 1)); //c2
    }

    public boolean isValidPalindrome(String s, int k) {
      return isValidPalindrome(s.toCharArray(), 0, s.length() - 1) <= k;
    }
  }

  class TopDownMemoized{
    private int [][] cache;
    public int isValidPalindrome(char[] s, int i, int j) {
      if (i == j) return 0;
      if (j-i == 1) return s[i] != s[j] ? 1 : 0;
      if(cache[i][j] != -1)
        return cache[i][j];

      if(s[i] == s[j])
        cache[i][j] = isValidPalindrome(s, i+1, j-1);
      else
        cache[i][j] = 1 + Math.min(isValidPalindrome(s, i+1,j), isValidPalindrome(s,i,j - 1));

      return cache[i][j];
    }

    public boolean isValidPalindrome(String s, int k) {
      cache = new int[s.length()][s.length()];
      for(int i = 0; i < s.length(); i++)
        Arrays.fill(cache[i], -1);
      return isValidPalindrome(s.toCharArray(), 0, s.length() - 1) <= k;
    }
  }

  class BottomUp {
    public boolean isValidPalindrome(String s, int k) {
      int[][] cache = new int[s.length()][s.length()];

      for (int i = s.length() - 2; i >= 0; i--)
        for (int j = i + 1; j < s.length(); j++) {
          if (s.charAt(i) == s.charAt(j))
            cache[i][j] = cache[i + 1][j - 1];
          else
            cache[i][j] = 1 + Math.min(cache[i + 1][j], cache[i][j - 1]);
        }

      return cache[0][s.length() - 1] <= k;
    }
  }

  class BottomUpSpaceOptimized {
    public boolean isValidPalindrome(String s, int k) {
      int cache[] = new int[s.length()], newval, old;

      for (int i = s.length() - 2; i >= 0; i--) {
        old = 0;
        for (int j = i + 1; j < s.length(); j++) {
          newval = cache[j];
          if (s.charAt(i) == s.charAt(j))
            cache[j] = old;
          else
            cache[j] = 1 + Math.min(cache[j], cache[j - 1]);
          old = newval;
        }
      }
      return cache[s.length() - 1] <= k;
    }
  }
}

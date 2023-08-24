package com.joshir.dynamic;

import java.util.Arrays;

public class LongestPalindromicSubstring {

  // This will TLE
  class LongestPalindromicSubstringBF {
    int max = Integer.MIN_VALUE, start = 0, end = 0;
    public boolean longestPalindrome(char[] s, int i, int j) {
      if( i == j ) return true;

      if(s[i] == s[j] && longestPalindrome(s, i+1, j-1)) {
        if( max < j - i + 1 ) {
          max = j - i + 1;
          start = i;
          end = j;
        }
        return true;
      }

      longestPalindrome(s, i + 1, j);
      longestPalindrome(s, i, j - 1);

      return false;
    }

    public String longestPalindrome(String s) {
      longestPalindrome(s.toCharArray(), 0, s.length()-1);
      return s.substring(start, end + 1);
    }
  }

  // This will not TLE
  class LongestPalindromicSubstringTopDownMemo{
    int[][] cache;
    int max = Integer.MIN_VALUE, start = 0, end = 0;

    public int longestPalindrome(char[] s, int i, int j) {
      if(i == j || i > j) return 1;
      if(cache[i][j] != -1) return cache[i][j];


      if(s[i] == s[j] && (cache[i][j] = longestPalindrome(s, i+1, j-1)) == 1) {
        if( max < j - i + 1 ) {
          max = j - i + 1;
          start = i;
          end = j;
        }
      }else
        cache[i][j] = 0;

      longestPalindrome(s, i + 1, j);
      longestPalindrome(s, i, j - 1);

      return cache[i][j];
    }

    public String longestPalindrome(String s) {
      cache = new int[s.length()][s.length()];
      for(int i = 0; i < cache.length; i++)
        Arrays.fill(cache[i], -1);
      longestPalindrome(s.toCharArray(), 0, s.length()-1);
      return s.substring(start, end + 1);
    }
  }

  class LongestPalindromicSubstringBottomUp {
    public static String longestPalindrome(String s) {
      int start = 0, end = 0,  max = Integer.MIN_VALUE;
      int n = s.length();
      boolean[][] cache = new boolean[n][n];
      for(int i = n-1; i >= 0; i--) {
        for(int j = i; j < n; j++) {
          cache[i][j] = s.charAt(i) == s.charAt(j) && ( j - i < 3 || cache[i+1][j-1]  );
          if(cache[i][j] && (j-i+1 > max)) {
            start = i;
            end = j;
            max = j-i+1;
          }
        }
      }
      return s.substring(start, end);
    }
  }

  class LongestPalindromeSubstringSpaceOptimized {
    public static String longestPalindrome(String s) {
      int start = 0, end = 0,  max = Integer.MIN_VALUE;
      int n = s.length();
      boolean[] cache = new boolean[n];

      for (int i = n - 1; i >= 0; i--) {
        for (int j = n - 1; j >= i; j--) {
          cache[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || cache[j-1]);
          if(cache[j] && (j-i+1 > max)) {
            start = i;
            end = j;
            max = j-i+1;
          }
        }
      }
      return s.substring(start, end);
    }
  }
}

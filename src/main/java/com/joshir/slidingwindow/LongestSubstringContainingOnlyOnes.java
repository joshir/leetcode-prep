package com.joshir.slidingwindow;

public class LongestSubstringContainingOnlyOnes {
  public int findLength(String s) {
    int ans = 0;

    for (int right = 0, curr = 0, left = 0; right < s.length(); right++) {
      if (s.charAt(right)== '0')
        curr++;

      while (curr > 1) {
        if (s.charAt(left) == '0')
          curr--;
        left++;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new LongestSubstringContainingOnlyOnes().findLength("1101100111"));
  }
}

package com.joshir.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringOfAllVowelsInOrder {
  class Solution {
    public int longestBeautifulSubstring(String word) {
      char [] arr = word.toCharArray();

      Set<Character> set = new HashSet<>();
      int max = 0;
      for(int right = 0, left = 0; right < arr.length; right++) {
        set.add(arr[right]);

        if(right > 0 && !isValid(arr[right-1], arr[right])){
          left = right;
          set.removeAll(Arrays.asList('a','e','i','o','u'));
          set.add(arr[left]);
        }

        if(set.size() == 5)
          max = Math.max(max, right - left + 1);
      }
      return max;
    }

    boolean isValid (char before, char current) {
      return (current - before >= 0);
    }
  }
}

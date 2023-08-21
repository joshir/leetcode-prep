package com.joshir.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctChars {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> m = new HashMap<>();
    char[] arr = s.toCharArray();
    int max = Integer.MIN_VALUE;

    for (int right = 0, left = 0; right < arr.length ; right++ ){
      m.put(arr[right], m.getOrDefault(arr[right], 0) +1);

      while(m.size() > k && left <= right){
        // no need to check if the map contains the key because it indeed will
        m.put(arr[left], m.get(arr[left] ) - 1);
        if(m.get(arr[left]) == 0)
          m.remove(arr[left]);
        left++;
      }

      max = Math.max(right - left +1, max);
    }
    return max;
  }
}

package com.joshir.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctChars {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int n = s.length();
    Map<Character, Integer> map = new HashMap<>(s.length()+1);
    char c, x;
    int max = Integer.MIN_VALUE;
    for(int right = 0, left = 0; right < n; right++ ) {
      c = s.charAt(right);
      map.put(c, map.getOrDefault(c,0) + 1);

      while( map.size() > 2 && left <= right) {
        x = s.charAt(left);
        map.put(x, map.get(x) - 1) ;
        if( map.get(x) == 0)
          map.remove(x);
        left++;
      }

      max = Math.max(max, right - left + 1);
    }
    System.gc();
    return max;
  }
}

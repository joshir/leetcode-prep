package com.joshir.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    int ans = Integer.MIN_VALUE;
    HashMap<Character, Integer> map = new HashMap<>();
    map.put(s.charAt(0),0);
    char curr;
    for(int left = 0, right = 0; right < s.length() - 1; ) {
      curr = s.charAt(++right);
      if (map.containsKey(curr) && map.get(curr) >= left)
        left = map.get(curr) + 1;
      map.put(curr, right);
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dawkcdewd"));
  }
}

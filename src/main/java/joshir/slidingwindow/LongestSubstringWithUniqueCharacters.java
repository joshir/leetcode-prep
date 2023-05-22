package joshir.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithUniqueCharacters {

  public static String longestSubstringWithUniqueChars(String str) {
    int s = 0, e = 0, maxlength = 0;
    String substr = null;
    HashMap<Character, Integer> map = new HashMap<>();
    map.put(str.charAt(0), 0);

    char curr;
    while(e < str.length()-1) {
      curr = str.charAt(++e);
      if (map.containsKey(curr) && map.get(curr) >= s)
        s = map.get(curr) + 1;
      map.put(curr, e);
      if(e - s + 1 > maxlength){
        maxlength = e - s + 1;
        substr = str.substring(s,e+1);
      }
    }
    return substr;
  }


  public static void main(String[] args) {
    System.out.println(longestSubstringWithUniqueChars("absndsewa"));
  }
}

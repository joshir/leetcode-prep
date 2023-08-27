package com.joshir.arrays;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    if (strs.length == 1) return strs[0];
    String lprefix = "";

    // optimum solution is brute force
    for (int i = 0; i < strs.length - 1; i++) {
      lprefix = prefix(i==0? strs[i]: lprefix, strs[i+1]);
      if(lprefix.isBlank() || lprefix.isEmpty())
        return "";
    }
    return lprefix;
  }

  private String prefix(String a, String b) {
    int i = 0;
    while(i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i))
      i++;
    return a.substring(0,i);
  }
}

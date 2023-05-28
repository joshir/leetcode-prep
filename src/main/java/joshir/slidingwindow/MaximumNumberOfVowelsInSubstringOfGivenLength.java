package joshir.slidingwindow;

import java.util.HashSet;
import java.util.List;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
  public int maxVowels(String s, int k) {
    if(s.isBlank() || s.isEmpty() || k == 0) return 0;

    HashSet<Character> vowels = new HashSet<>(List.of('a','e','i','o','u'));
    char curr;
    int count = 0, maxcount = Integer.MIN_VALUE;

    for (int right = 0; right < s.length(); right++) {
      curr = s.charAt(right);
      if(vowels.contains(curr)) count++;

      if (right >= k - 1) {
        maxcount = Math.max(count, maxcount);
        if (vowels.contains(s.charAt(right-k+1))){
          count--;
        }
      }
    }
    return maxcount;
  }

  public static void main(String[] args) {
    System.out.println(new MaximumNumberOfVowelsInSubstringOfGivenLength().maxVowels("leetcode",3));
  }
}

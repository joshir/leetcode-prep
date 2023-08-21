package com.joshir.slidingwindow;

public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int ones = 0, longest = 0;
    for(int i = 0; i < nums.length; i++)
      longest = Math.max(ones = (nums[i] == 0) ? 0 : ones+1, longest);
    return longest;
  }
}

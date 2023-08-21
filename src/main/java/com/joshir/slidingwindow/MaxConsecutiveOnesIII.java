package com.joshir.slidingwindow;

public class MaxConsecutiveOnesIII {
  public int longestOnes(int[] nums, int k) {
    int len = 0, max = 0;
    for(int right = 0, left = 0; right < nums.length; right++) {
      if(nums[right]==0)
        len++;
      while(len > k) {
        if (nums[left] == 0)
          len--;
        left++;
      }
      max = Math.max(right - left +1, max);
    }
    return max;
  }
}

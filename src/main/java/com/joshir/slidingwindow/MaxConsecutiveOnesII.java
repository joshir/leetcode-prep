package com.joshir.slidingwindow;

public class MaxConsecutiveOnesII {
  public int findMaxConsecutiveOnes(int[] nums) {
    int len = 0, max = 0;
    for(int right = 0, left = 0; right < nums.length; right++) {
      if(nums[right]==0)
        len++;
      if(len > 1) {
        if (nums[left] == 0)
          len--;
        left++;
      }
      max = Math.max(right - left +1, max);
    }
    return max;
  }
}

package com.joshir.twoptr;

import java.util.Arrays;

public class ThreeSumSmaller {
  public int threeSumSmaller(int[] nums, int target) {
    int count = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int j = i+1, k = nums.length -1;

      while(j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < target){
          count += k-j;
          j++;
        }else
          k--;
      }

    }
    return count;
  }
}

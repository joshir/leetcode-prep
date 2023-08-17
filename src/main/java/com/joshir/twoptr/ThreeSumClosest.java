package com.joshir.twoptr;

import java.util.Arrays;

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE, closest_sum = 0;
    for(int i = 0; i < nums.length - 2; i++) {
      int j = i+1, k = nums.length - 1;
      while(j < k){
        int s = nums[i] + nums [j] + nums[k];
        int diff = Math.abs(s-target);
        if(diff < min) {
          min = diff;
          closest_sum = s;
        }
        if(s < target) {
          j++;
        }else if(s >= target){
          k--;
        }else {
          return target;
        }
      }
    }
    return closest_sum;
  }
}

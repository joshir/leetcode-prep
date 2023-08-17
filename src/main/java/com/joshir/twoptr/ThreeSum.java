package com.joshir.twoptr;

import java.util.*;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 2; i++ ){
      /* apply 2 pointer on each i */
      int p = i+1, q = nums.length-1;
      while (p < q){
        int sum = nums[i]+nums[p]+nums[q];
        if(sum < 0)
          p++;
        else if(sum > 0)
          q--;
        else{
          set.add(Arrays.asList(nums[i],nums[p],nums[q]));
          p++;
          q--;
        }
      }
    }

    return new ArrayList<>(set);
  }
}

package com.joshir.hmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      int next = map.getOrDefault(target-nums[i],-1);
      if(next != -1 && i != next){
        return new int[] {i, map.get(target-nums[i])};
      }
      map.put(nums[i], i);
    }
    return new int[0] ;
  }
}

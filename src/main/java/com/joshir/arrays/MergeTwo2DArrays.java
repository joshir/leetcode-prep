package com.joshir.arrays;

import java.util.Map;
import java.util.TreeMap;

public class MergeTwo2DArrays {
  class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
      Map<Integer,Integer> map = new TreeMap<>();
      int [] row;

      for (int i = 0; i < Math.min(nums1.length, nums2.length); i++) {
        row = nums1[i];
        map.put(row[0], map.getOrDefault(row[0], 0) + row[1]);
        row = nums2[i];
        map.put(row[0], map.getOrDefault(row[0], 0) + row[1]);
      }

      for (int i = Math.min(nums1.length, nums2.length); i < Math.max(nums1.length, nums2.length); i++) {
        row = nums1.length< nums2.length? nums2[i]:nums1[i];
        map.put(row[0], map.getOrDefault(row[0], 0) + row[1]);
      }

      int[][] retArray = new int[map.size()][];
      int i = 0;
      for(var entry: map.entrySet())
        retArray[i++] = new int[] {entry.getKey(), entry.getValue()};

      return retArray;
    }
  }
}

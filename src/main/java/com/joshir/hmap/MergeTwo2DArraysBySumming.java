package com.joshir.hmap;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MergeTwo2DArraysBySumming {
  public static int[][]  mergeArrays(int[][] nums1, int[][] nums2) {
    Map<Integer,Integer> map = new TreeMap<>();
    int [] row;
    for (int i = 0; i < nums1.length; i++) {
      row = nums1[i];
      map.put(row[0], map.getOrDefault(row[0], 0) + row[1]);
    }

    for (int i = 0; i < nums2.length; i++) {
      row = nums2[i];
      map.put(row[0], map.getOrDefault(row[0], 0) + row[1]);
    }

    int[][] retArray = new int[map.size()][];
    int i = 0;
    for(var entry : map.entrySet())
      retArray[i++] = new int[] {entry.getKey(), entry.getValue()};
    Arrays.sort(retArray);
    return retArray;
  }

  public static void main(String[] args) {
    int[][] nums1 = new int[][]  {{1,2}, {2,3}, {4,5}};
    int[][] nums2 = new int[][]  {{1,4}, {3,2}, {4,1}};
    mergeArrays(nums1, nums2);
  }
}

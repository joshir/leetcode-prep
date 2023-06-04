package com.joshir.priorityqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SubsequenceKWithLargestSum {

  private PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
  public int[] maxSubsequence(int[] nums, int k) {
    return null;
  }

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new SubsequenceKWithLargestSum().maxSubsequence(new int[] {-1,-2,3,4}, 3)));
  }
}

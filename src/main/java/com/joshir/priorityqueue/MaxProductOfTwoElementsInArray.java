package com.joshir.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProductOfTwoElementsInArray {

  PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

  public int maxProduct(int[] nums) {
    for(int i = 0; i< nums.length; i++)
      pq.offer(nums[i]);
    return (pq.poll() -1) * (pq.poll() -1);
  }

  public static void main(String[] args) {
    System.out.println(new MaxProductOfTwoElementsInArray().maxProduct(new int[] {1,5,4,5}));
  }
}

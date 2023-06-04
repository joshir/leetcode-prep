package com.joshir.priorityqueue;

import java.util.PriorityQueue;

public class KthLargest {
  private final int k;
  private final PriorityQueue<Integer> priority;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    priority = new PriorityQueue<>();

    for (int n : nums) priority.offer(n);
    // kth-largest element is accessible when
    // p q is of size k so remove until size is k
    while (priority.size() > k) priority.poll();
  }

  public int add(int val) {
    priority.offer(val);
    if (priority.size() > k) priority.poll();
    return priority.peek();
  }
}

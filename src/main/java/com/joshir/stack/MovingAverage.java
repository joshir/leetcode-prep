package com.joshir.stack;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

  private final int windowSize;

  private int sum = 0;

  private static Queue<Integer> queue = new LinkedList<>();

  public MovingAverage(int size) {
    this.windowSize = size;
  }

  public double next(int val) {
    queue.add(val);

    if(queue.size() >= windowSize)
      sum = sum - queue.poll() + val;
    else
      sum += val;

    return queue.size() < windowSize ?  sum / (double) queue.size(): sum / (double)windowSize;
  }
}

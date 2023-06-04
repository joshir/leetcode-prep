package com.joshir.stack;

import java.util.Arrays;
import java.util.LinkedList;

public class NextGreaterRightTwo {
  public static void main(String[] args) {
    int[] arr = {5,6,7,1,2,3,9};
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString( fillGreaterRight(arr)));
  }
  private static int[] fillGreaterRight(int [] arr) {
    int[] ngr = new int[arr.length];
    LinkedList<Integer> stack = new LinkedList<>();

    stack.add(0);
    int index = 0;
    while (++index < arr.length) {
      while(stack.size() > 0 && arr[index] > arr[stack.peekLast()])
        ngr[stack.removeLast()] = arr[index];
      stack.add(index);
    }

    while(stack.size() > 0)
      ngr[stack.removeLast()] = -1;

    return ngr;
  }
}

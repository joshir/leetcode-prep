package com.joshir.stack;

import java.util.Arrays;
import java.util.LinkedList;

public class NextGreaterRight {
  public static void main(String[] args) {
    int[] arr = {1,6,2,4,5,9,11,22,8,10,51};
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString( fillGreaterRight(arr)));
  }

  private static int[] fillGreaterRight(int [] arr) {
    int[] ngr = new int[arr.length];
    LinkedList<Integer> stack = new LinkedList<>();

    stack.add(arr[arr.length-1]);
    ngr[arr.length - 1] = -1; /* no element to the right*/

    int index = arr.length - 1;
    while (--index >= 0) {
      while(stack.size() > 0 && stack.peekLast() < arr[index])
        stack.removeLast();

      ngr[index] = stack.size() == 0 ? -1 : stack.peekLast();

      stack.add(arr[index]);
    }
    return ngr;
  }
}

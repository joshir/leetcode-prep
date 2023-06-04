package com.joshir.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class NextSmallerLeft {

  public static int[] fillNextSmallerLeft(int[] arr) {
    int[] items = new int[arr.length];
    LinkedList<Integer> stack = new LinkedList<>() ;

    items[0] = -1; /* nothing to the left of 0th item */
    stack.add(arr[0]);

    IntStream.range(1, arr.length).forEach(index -> {
      while(stack.size() > 0 && arr[index] < stack.peekLast())
        stack.removeLast();

      items[index] = stack.size() > 0? stack.peekLast(): -1;
      stack.add(arr[index]);
    });
    return items;
  }
  public static void main(String[] args) {
    int[] arr = {5,6,7,1,2,3,9};
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString( fillNextSmallerLeft(arr)));
  }
}

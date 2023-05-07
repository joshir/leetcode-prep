package joshir.stacks;

import java.util.Arrays;
import java.util.LinkedList;

public class NextSmallerRightTwo {
  private static int[] fillSmallerRight(int [] arr) {
    int[] nsr = new int[arr.length];
    LinkedList<Integer> stack = new LinkedList<>();

    int index = 0;
    stack.add(0);
    while (++index < arr.length) {
      while(stack.size() > 0 && arr[index] < arr[stack.peekLast()])
        nsr[stack.removeLast()] = arr[index];
      stack.add(index);
    }

    while(stack.size() > 0)
      nsr[stack.removeLast()] = -1;

    return nsr;
  }
  public static void main(String[] args) {
    int[] arr = {5,7,8,6,4,3,2,9,10,1};
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString( fillSmallerRight(arr)));
  }
}

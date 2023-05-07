package joshir.stacks;

import java.util.Arrays;
import java.util.LinkedList;

public class NextGreaterLeft {

  private static int[] fillGreaterLeft(int [] arr) {
    int[] ngl = new int [arr.length];
    LinkedList<Integer> stack = new LinkedList<>();

    ngl[0] = -1;
    stack.add(arr[0]);
    for(int index = 1; index < arr.length; index++){

      while(stack.size()>0 && arr[index] > stack.peekLast())
        stack.removeLast();

      ngl[index] = stack.size() == 0 ? -1: stack.peekLast();

      stack.add(arr[index]);
    }

    return ngl;
  }

    public static void main(String[] args) {
      int[] arr = {5,6,7,1,2,3,9};
      System.out.println(Arrays.toString(arr));
      System.out.println(Arrays.toString( fillGreaterLeft(arr)));
  }
}

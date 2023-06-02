package joshir.stack;

import java.util.HashMap;
import java.util.LinkedList;

public class MaxHistogramArea {

  private static final LinkedList<Integer> stack = new LinkedList<>(); /* TODO use indexed stack or ArrayDeque as a stack */

  /* current entry mapped to pair with smaller el on left and right for this entry */
  private static final HashMap<Integer, Pair> map = new HashMap<>();

  final static class Pair {
    Integer i1;
    Integer i2;
  }

  public static int getMaxHistogramArea(int[] arr) {

    /* find left boundary */
    Pair temp = new Pair();
    temp.i1 = -1;  /* no smaller element for the leftmost element */
    temp.i2 = -1;
    stack.add(0);
    map.put(0,temp);
    for (int i = 1; i < arr.length; i++){
      temp = new Pair();
      while(!stack.isEmpty() && arr[stack.peekLast()] >= arr[i]){
        /* next smaller el on the right */
        map.get(stack.removeLast()).i2 = i;
      }

      /* if stack is empty, there's no smaller element on the left; otherwise, what's on top of the stack is what's smaller on the left*/
      temp.i1 = stack.isEmpty() ? -1 : stack.peekLast();
      map.put(i, temp);
      stack.add(i);
    }

    /*
     * elements that are still on the stack represent
     * those that could not be displaced,
     * so they have no smaller elements on the right
     * */
    while(!stack.isEmpty())
      map.get(stack.removeLast()).i2 = arr.length;

    int maxArea = 0;
    for (int i = 0; i < map.size(); i++){
      temp = map.get(i);
      maxArea = Math.max(maxArea, (temp.i2 - temp.i1 - 1) * arr[i] );
    }
    return maxArea;
  }

  public static void main(String[] args) {
    int[] arr = {6,2,5,4,5,1,6};
    System.out.println(getMaxHistogramArea(arr));
  }
}
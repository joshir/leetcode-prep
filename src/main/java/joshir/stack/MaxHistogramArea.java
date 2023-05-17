package joshir.stack;

import java.util.HashMap;
import java.util.LinkedList;

public class MaxHistogramArea {

  private static final LinkedList<Integer> stack = new LinkedList<>();

  private static final HashMap<Integer, Pair> map = new HashMap<>();

  final static class Pair {
    Integer i1;
    Integer i2;
  }

  public static int getMaxHistogramArea(int[] arr) {

    /* find left boundary */
    Pair pl = new Pair();
    pl.i1 = -1;  /* no smaller element for the leftmost element */
    pl.i2 = -1;
    stack.add(0);
    map.put(0,pl);
    Pair p1;
    for (int i = 1; i < arr.length; i++){
      p1 = new Pair();
      while(!stack.isEmpty() && arr[stack.peekLast()] > arr[i]){
        /* next smaller el on the right */
        map.get(stack.removeLast()).i2 = i;
      }

      if(stack.isEmpty()) {
        p1.i1 = -1;
        map.put(i, p1);
      }
      else if (!stack.isEmpty() && arr[stack.peekLast()] < arr[i]){
        p1.i1 = stack.peekLast();
        map.put(i, p1);
      }
      stack.add(i);
    }

    /*
     * elements that are still on the stack represent
     * those that could not be displaced,
     * so they have no smaller elements on the right
     * */
    while(!stack.isEmpty())
      map.get(stack.removeLast()).i2 = arr.length;

    Pair pair;
    int maxArea = 0;
    for (int i = 0; i < map.size(); i++){
      pair = map.get(i);
      maxArea = Math.max(maxArea, (pair.i2 - pair.i1 - 1) * arr[i] );
    }
    return maxArea;
  }

  public static void main(String[] args) {
    int[] arr = {6,2,5,4,5,1,6};
    System.out.println(getMaxHistogramArea(arr));
  }
}
package joshir.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
    stack.add(0);
    map.put(0,pl);
    Pair p1;
    for (int i = 1; i < arr.length; i++){
      p1 = new Pair();
      while(!stack.isEmpty() && arr[stack.peekLast()] > arr[i])
        stack.pop();
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

    /* find right boundary */
    stack.clear();
    stack.add(arr.length - 1);
    Pair pr = map.get(arr.length-1);
    pr.i2 = arr.length;  /* no smaller element for the rightmost element */
    for(int i = arr.length - 2; i >= 0; i--){
      while(!stack.isEmpty() && arr[i] < arr[stack.peekLast()])
        stack.pop();
      if(stack.isEmpty())
        map.get(i).i2 = arr.length;
      else if(!stack.isEmpty() && arr[i] > arr[stack.peekLast()])
        map.get(i).i2 = stack.peekLast();
      stack.add(i);
    }

    Pair pair;
    int maxArea = 0;
    for (int i = 0; i < map.size(); i++){
      pair = map.get(i);
      maxArea = Math.max(maxArea, (pair.i2 - pair.i1) * arr[i] );
    }
    return maxArea;
  }

  public static void main(String[] args) {
    int[] arr = {2,6,1,3,4,7,9,22};
    System.out.println(getMaxHistogramArea(arr));
  }
}
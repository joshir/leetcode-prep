package joshir.stack;

import java.util.Arrays;
import java.util.LinkedList;

public class DailyTemperatures {
  private LinkedList<Integer> stack = new LinkedList<>();

  public int[] findHigherTemp(int[] temps) {
    int[] arr = new int[temps.length];
    /* O(N) time and O(N) space*/
    for (int index = 0, next; index < temps.length; index++) {
      /* O(1) Amortized since this loop does not repeat over the same elements more than once */
      while(!stack.isEmpty() && temps[stack.peek()] <= temps[index]) {
        next = stack.pop();
        arr[next] = index - next;
      }
        stack.push(index);
    }
    return arr;
  }


  public static void main(String[] args) {
    System.out.println(Arrays.toString(new DailyTemperatures().findHigherTemp(new int[] {7,8,6,5,4,3,2,1,9})));
  }
}

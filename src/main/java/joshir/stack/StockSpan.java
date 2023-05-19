package joshir.stack;

import java.util.Arrays;
import java.util.LinkedList;

public class StockSpan {

  /*
  * find the span of stock price at any index.
  * span is the number of days from today to the
  * next greater price in the past.
  * so for [2,6,1,3,4,7,9,22], the span for 4
  * would be 3. span for any day that does not have
  * price greater in the past is its position in the
  * array indexed at 1.
  * */
  private static int[] fillSpan(int[] arr) {
    int[] span_arr = new int[arr.length];
    LinkedList<Integer> stack = new LinkedList<>();

    stack.add(0);
    span_arr[0] = 1;  /* span to the right of leftmost element is 1*/
    for(int i = 1; i < arr.length; i++) {
      while(stack.size() > 0 && arr[i] > arr[stack.peekLast()])
        stack.removeLast();
      span_arr[i] = stack.size() == 0 ? i + 1: i - stack.peekLast() ;
      stack.add(i);
    }
    stack.clear();
    return span_arr;
  }
  public static void main(String[] args) {
    int[] arr = {2,6,1,3,4,7,9,22};
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(fillSpan(arr)));
  }
}

package joshir.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxSlidingWindow {
  private ArrayDeque<Integer> deque = new ArrayDeque<>();
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] ans = new int[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {
      while (!deque.isEmpty() && nums[i] > nums[deque.getLast()])
        deque.removeLast();

      /*
      * add after making sure monotonic
      * decreasing property is maintained
      * */
      deque.addLast(i);

      /*
      * when window has moved out of range
      * remove the max element from the bottom of the deque
      * */
      if (deque.getFirst() + k == i)
        deque.removeFirst();

      if (i >= k - 1)
        ans[i - k + 1] = nums[deque.getFirst()];
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[] {1,2,3,4,8,5,6,7}, 3)));
  }
}

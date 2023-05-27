package joshir.slidingwindow;

import java.util.LinkedList;

public class MaxSubArrarAverageOne {
  public static void main(String[] args) {
    System.out.println(new MaxSubArrarAverageOne().findMaxAverage(new int[] {1,12,-5,-6,50,3},4));
  }
  public double findMaxAverage(int[] nums, int k) {
    int max = Integer.MIN_VALUE;
    for (int index = 0, sum = 0; index < nums.length; index++){
      sum+= nums[index]; /* right */
      if (index>=k){
        sum-=nums[index-k]; /* left */
      }
      max = Math.max(sum,max);
    }
    return max/(double)k;
  }
}

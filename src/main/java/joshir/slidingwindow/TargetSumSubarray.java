package joshir.slidingwindow;

import java.util.Arrays;

public class TargetSumSubarray {

  public int[] subarraySum(int[] arr, int target) {
    int start = 0, end = 0;
    int sasum = arr[0];
    int[] retArr = null;
    while(true) {
      if(start > end) sasum = arr[end = start];

      if(sasum < target) {
        if(end==arr.length-1) break;
        sasum += arr[++end];
      }
      else if (sasum > target){
        if(start==arr.length) break;
        sasum -= arr[start++];
      }
      else{
        retArr = new int[end-start+1];
        for(int cursor = 0; start < end + 1;)
          retArr[cursor++] = arr[start++];
        break;
      }
    }

    return retArr;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new TargetSumSubarray().subarraySum(new int[] {1,9,3,8,2}, 7)));
  }
}

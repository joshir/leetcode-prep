package joshir.slidingwindow;

import java.util.Arrays;

public class TargetSumSubarray {

  public int[] subarraySum(int[] arr, int target) {
    int start = 0, end = 0;
    for (int sasum = arr[0]; start < arr.length; ){
      if(start > end) sasum = arr[end = start];

      if(sasum < target) {
        if(end == arr.length-1) break;
        sasum += arr[++end];
      }
      else if (sasum > target)
        sasum -= arr[start++];
      else if (sasum == target)
        break;
    }

    int[] retArr = new int[end-start+1];
    for(int cursor = 0; start < end+1;)
      retArr[cursor++] = arr[start++];

    return retArr;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new TargetSumSubarray().subarraySum(new int[] {1,2,3,5,2}, 8)));
  }
}

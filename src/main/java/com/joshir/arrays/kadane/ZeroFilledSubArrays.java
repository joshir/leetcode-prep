package com.joshir.arrays.kadane;

public class ZeroFilledSubArrays {
  public long zeroFilledSubarray(int[] nums) {
    long zeroLength = 0, zeroWindows = 0;

    for (int i = 0; i < nums.length; i++ ) {
      // simillar to Kadane's
      zeroLength = (nums[i]==0) ? (zeroLength + 1) : 0;
      zeroWindows += zeroLength;
    }
    return zeroWindows;
  }
}

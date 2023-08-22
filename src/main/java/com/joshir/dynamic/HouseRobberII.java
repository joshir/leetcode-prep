package com.joshir.dynamic;

public class HouseRobberII {
  public int rob(int[] nums) {
    if(nums.length == 1) return nums[0];
    if(nums.length == 2) return Math.max(nums[0], nums[1]);

    // partition the circle at N-1, 0 to create two
    // arrays and run House Robber 1 on arrays 0 to N-2 and 1 to N-1 each
    // return max.

    return Math.max(rob(nums,0, nums.length-1),rob(nums,1, nums.length) );
  }

  private int robBottomUp(int [] nums, int start, int end)
  {
    int robfirst = 0, robnext = 0;

    for(int i = start; i< end; i++)
    {
      int temp = Math.max(nums[i] + robfirst, robnext);
      robfirst = robnext;
      robnext = temp;
    }
    return robnext;
  }

  public int rob(int[] nums, int start, int end) {
    int dp[] = new int[end-start];


    dp[0] = nums[start];
    dp[1] = Math.max(dp[0], nums[start+1]);

    for(int i = start+2; i< end; i++){
      dp[i-start] = Math.max( nums[i] + dp[i-start-2], dp[i-start-1]);
    }

    return dp[dp.length-1];
  }
}

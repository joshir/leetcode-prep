package joshir.slidingwindow;

public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
    int ans = Integer.MAX_VALUE;
    for (int right = 0, sum = 0, left = 0; right < nums.length; right++) {
      sum += nums[right];
      while(sum >= target) {
        ans = Math.min(right - left + 1, ans );
        sum-=nums[left];
        left++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
  }
}

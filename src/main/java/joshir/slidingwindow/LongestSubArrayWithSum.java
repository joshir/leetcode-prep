package joshir.slidingwindow;

public class LongestSubArrayWithSum {
  public static void main(String[] args) {
    System.out.println(new LongestSubArrayWithSum().findLength(new int[]{1000, 9, 3, 8, 2}, 7));
  }

  public int findLength(int[] nums, int k) {
    int ans = 0;

    for (int right = 0, left = 0, curr = 0; right < nums.length; right++) {
      curr += nums[right];
      while (curr > k) {
        curr -= nums[left];
        left++;
      }

      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }
}

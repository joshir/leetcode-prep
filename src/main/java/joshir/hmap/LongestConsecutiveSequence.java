package joshir.hmap;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

  private Map<Integer, Integer> map = new HashMap<>();

  public int longestConsecutive(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if(-1 == map.getOrDefault(nums[i], -1)){
        if( -1 != map.getOrDefault(nums[i]-1, -1) )
          count++;
        if( -1 != map.getOrDefault(nums[i]+1, -1))
          count++;
      }
      map.put(nums[i],map.getOrDefault(nums[i], 0) + 1 );
    }
    return count+1;
  }
  public static void main(String[] args) {
//    System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
//    System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[] {100,4,200,1,3,2}));
//    System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[] {1,2,0,1}));
    System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[] {9,1,4,7,3,-1,0,5,8,-1,6}));

  }
}

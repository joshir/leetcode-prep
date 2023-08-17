package com.joshir.twoptr;

public class TwoSumTwo {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    while(i < j ) {
      if(numbers[i]+numbers[j]>target)
        j--;
      else if(numbers[i]+numbers[j]<target)
        i++;
      else
        break;
    }

    /* existence of a Pair is guaranteed*/
    int k[] = {i+1,j+1};
    return k;
  }
}

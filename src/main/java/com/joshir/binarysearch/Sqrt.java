package com.joshir.binarysearch;

public class Sqrt {
  class Solution {
    public int mySqrt(int x) {
      if (x == 0 || x == 1) return x;
      long n = 0;

      int mid, left = 2, right = x / 2;
      while (left <= right) {
        mid = left + (right - left) / 2;
        n = (long) mid * mid;
        if (n > x) right = mid - 1;
        else if (n < x) left = mid + 1;
        else return mid;
      }

      return right;
    }
  }
}

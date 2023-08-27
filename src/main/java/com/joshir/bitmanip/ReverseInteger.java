package com.joshir.bitmanip;

public class ReverseInteger {
  class Solution {
    public int reverse(int x) {
      int n = x, rev = 0;
      int prev_rev = 0;
      while ( n != 0 ){
        rev = rev*10 + n%10;

        // rev may have changed signs after the last operation
        if((x>0 && rev<0) || (x<0 && rev > 0))
          return 0;

        // rev may not have changed signs but still overshot and clocked around to the same sign
        if(Math.abs(prev_rev) > Math.abs(rev))
          return 0;

        // this will work for all cases but is not preferred. it helps pass the last two cases 1044, 1045
        if(prev_rev != rev/10)
          return 0;

        n /= 10;
        prev_rev = rev;
      }
      return rev;
    }

    public int reverseEditorial(int x) {
      int rev = 0;
      while (x != 0) {
        int pop = x % 10;
        x /= 10;
        if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
        if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
        rev = rev * 10 + pop;
      }
      return rev;
    }
  }

// -2^31 to 0 to 2^31 -1
//  -2147483648 to 2147483647

// 7463847412
}

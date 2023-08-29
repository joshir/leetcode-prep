package com.joshir.math;

public class Power {
  class Solution {
    private double[] powers;
    public double myPow(double x, int n) {
      if(x == 0) return 0;
      if(n == 1) return x;

      powers = new double[Math.abs(n)+1];
      double m = pow(x, Math.abs(n));

      return n>0 ? m : 1/m ;
    }

    public double pow(double x, int n) {
      if(n <= 1)
        powers[n] = 1;
      if(n == 2)
        powers[n] = x*x;

      if(powers[n] != 0) return powers[n];

      if (n % 2 == 0)
        // speedup from this is of logarithmic order namely log(n)
        powers[n] = pow(x, n / 2) * pow(x, n / 2) ;
      else
        powers[n] = x * pow(x, n-1);

      return powers[n];
    }
  }
}

package com.joshir.recursion.one;

import java.util.Scanner;

public class ZigZag {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    zzag(in.nextInt());

  }

  public static void zzag(int n) {
    if( n <= 0 ) return;

    System.out.println(+n);
    zzag(n-1);
    System.out.println(n);
    zzag(n-1);
    System.out.println(n);

  }
}

package com.joshir.slidingwindow;

public class KBeauty {

  public int divisorSubstrings(int num, int k) {
    String str = Integer.toString(num);
    int kbeauty = 0;
    for (int left = 0, curr = 0; left <= str.length() - k ; left++ ) {
      curr = Integer.valueOf(str.substring(left, left+k));
      if(curr!=0 && num%curr==0) kbeauty++;
    }
    return kbeauty;
  }

  public static void main(String[] args) {
    System.out.println(new KBeauty().divisorSubstrings(430043,2));
  }
}

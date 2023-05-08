package joshir.bitmanip;

public class Kernighan {
  public static void main(String[] args) {
    System.out.println(countSetBits(500));
  }


  /*
   * continuously subtract right most set bit
   * and count set bit until n is 0
   * */
  public static int countSetBits(int n) {
    int setbit = 0;
    for (;n != 0; n -= (n & -n)) setbit++;
    return setbit;
  }
}

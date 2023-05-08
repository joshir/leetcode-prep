package joshir.bitmanip;

public class Kernighan {
  public static void main(String[] args) {
    System.out.println(countSetBits(-1));
  }


  /*
   * continuously subtract right most set bit
   * and count set bit until n is 0
   * */
  public static byte countSetBits(int n) {
    byte setbit;
    for (setbit = 0; n != 0; n -= (n & -n), setbit++) ;

    return setbit;
  }
}

package joshir.recursion.v13;

public class DispArrRev {
  public static void main(String[] args) {
    int[] arr = {10,20,30,40,50};
    dispArrRev(arr, 0);
  }

  private static void dispArrRev(int[] arr, int i) {
    if(i == arr.length) return;

    dispArrRev(arr, i+1);
    System.out.println(arr[i]);
  }
}

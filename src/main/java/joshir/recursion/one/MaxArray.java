package joshir.recursion.one;


public class MaxArray {
  public static void main(String[] args) {
    int[] arr = {10,20,30,40,50};
    System.out.println(maxArr(arr, 0));
  }

  private static int maxArr(int[] arr, int index) {
    if (index == arr.length) return Integer.MIN_VALUE;
    int misa = maxArr(arr, index+1);
    int currentMax = Math.max(arr[index], misa);
    return currentMax;
  }
}

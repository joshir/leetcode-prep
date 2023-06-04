package com.joshir.recursion.one;

public class FirstIndex  {
  public static void main(String[] args) {
    int[] arr = {5,3,9,4,1,5,7,3,7};
    int found = firstIndex(arr, 0, 7);

    if(found != -1){
      System.out.println("Found "+ 7 + " at "+found);
    }
  }
  public static int firstIndex(int[] arr,int index, int search) {
    if(index == arr.length) return -1;

    if(arr[index] == search) return index;

    int found = firstIndex(arr, index+1, search );

    return found;
  }
}

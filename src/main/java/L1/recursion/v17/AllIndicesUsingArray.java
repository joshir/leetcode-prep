package L1.recursion.v17;

import java.util.Arrays;

public class AllIndicesUsingArray {
  public static void main(String[] args) {
    int[] arr = {5,3,9,4,1,5,7,3,7};
    System.out.println(
      Arrays.toString(allIndices(arr, 0, 0, 3))
    );
  }

  public static int[] allIndices(int[] arr, int index, int size, int val) {
    if(arr.length == index) return new int[size];

    if(arr[index] == val){
      size++;
    }

    int[] indexArr = allIndices(arr, index+1, size, val);

    if ( arr[index] == val) {
      indexArr[size-1] = index;
    }

    return indexArr;
  }
}

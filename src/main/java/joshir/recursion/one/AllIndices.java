package joshir.recursion.one;

import java.util.ArrayList;
import java.util.List;

public class AllIndices {
  public static void main(String[] args) {
    int[] arr = {5,3,9,4,1,5,7,3,7};
    allIndices(arr, 0, 7).forEach(System.out::println);
  }

  public static List<Integer> allIndices(int [] arr, int index, int search) {
    if(arr.length == index) return new ArrayList<>();

    List<Integer> found = allIndices(arr, index + 1, search );
    if (search == arr[index]) {
      found.add(index);
    }

    return found;
  }
}

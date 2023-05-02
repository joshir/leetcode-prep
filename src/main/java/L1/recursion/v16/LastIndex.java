package L1.recursion.v16;

public class LastIndex {
  public static void main(String[] args) {
    int[] arr = {5,3,9,4,1,5,7,3,7};
    System.out.println(lastIndexOf(arr, 0, 2));
  }

  public static int lastIndexOf(int [] arr, int index, int search) {
    if(index == arr.length) return -1;

    int found = lastIndexOf(arr, index+1, search);
    if (found == -1 && search == arr[index])
      return index;
    return found;
  }
}

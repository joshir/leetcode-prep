package L1.recursion.v12;

public class DispArray {
  public static void main(String[] args) {
    int[] arr = {10,20,30,40,50} ;

    dispArray(arr, 0);
  }

  private static void dispArray(int[] arr, int start) {
    if(start == arr.length) return;
    System.out.println(arr[start]);
    dispArray(arr, start+1);
  }

}

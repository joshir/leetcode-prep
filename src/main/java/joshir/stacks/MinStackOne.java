package joshir.stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MinStackOne {
  private static final MinStack<Integer> stack = new MinStack<>(20);

  /*
  * Simple stack impl using a backing array
  * */
  private static class MinStack<T extends Comparable<? super T>> {

    private final T[] backing;

    private final T[] minimums;

    private int min = -1;

    private int tos = -1;

    @SuppressWarnings("unchecked")
    MinStack(int size) {
      backing = (T[]) new Comparable[size];
      minimums = (T[]) new Comparable[size];
    }

    void push(T el) {
      if (tos>=backing.length) throw new StackOverflowError();
      if (tos==-1) {
        backing[++tos] = el;
        minimums[++min] = el;
        return;
      }
      else if (el.compareTo(minimums[min]) < 0)
        minimums[++min] = el;

      backing[++tos] = el;
    }

    T pop() {
      if (tos<=-1) throw new EmptyStackException();
      if(minimums[min].equals(backing[tos])){
        min--;
      }
      return backing[tos--];
    }

    T min() {
      if(tos==-1)
        throw new EmptyStackException();
      return minimums[min];
    }

    int isRemaining() {return tos;}
  }

  public static void main(String[] args) {
    int[] nums = new int[]{31, 22, 9, 10, 11, 2 , 3, 99, 1, 39};
    System.out.println(Arrays.toString(nums));
    for (Integer i: nums){
      stack.push(i);
      System.out.print(stack.min()+", ");
    }

    System.out.println();

    while(stack.isRemaining() >0){
      stack.pop();
      System.out.print(stack.min()+", ");
    }
  }
}

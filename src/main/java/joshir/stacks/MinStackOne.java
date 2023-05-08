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
      else {
        int tmin = min;
        while(--tmin>-1){
          if(backing[min].equals(minimums[tmin])) {
            while(tmin!=min ){
              minimums[tmin] = minimums[tmin+1];
              tmin++;
            }
            break;
          }
        }
      }
      return backing[tos--];
    }

    T min() {
      if(tos==-1)
        throw new EmptyStackException();
      return minimums[min];
    }

    int size(){return tos+1;}
  }

  public static void main(String[] args) {
    int[] nums = new int[]{31, 22, 9, 10, 11, 3, 99, 39, 1};
    System.out.println(Arrays.toString(nums));
    for (Integer i: nums){
      stack.push(i);
      System.out.print(stack.min()+", ");
    }

    System.out.println();

    while(stack.size()>0){
      System.out.print(stack.min()+", ");
      stack.pop();
    }
  }
}

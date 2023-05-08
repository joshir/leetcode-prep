package joshir.stacks;

import java.util.EmptyStackException;

/*
* Simple min/max stack for any Comparable type using two backing array
* with O(1) min or max lookups and O(N) extra space
* */
public class MinMaxStack<T extends Comparable<? super T>> {

  /* main backing store */
  private final T[] backing;

  /* store for mins or maxs*/
  private final T[] minimums;

  private final T[] maximums;


  private int tos = -1;

  private int mintop = -1;

  private int maxtop = -1;


  public MinMaxStack() {
    this(20);
  }

  @SuppressWarnings("unchecked")
  public MinMaxStack (int size) {
    backing = (T[]) new Comparable[size];
    minimums = (T[]) new Comparable[size];
    maximums = (T[]) new Comparable[size];
  }

  public void push(T el) {
    if (tos>=backing.length) throw new StackOverflowError();
    if (isEmpty()) {
      backing[++tos] = el;
      minimums[++mintop] = el;
      maximums[++maxtop] = el;
      return;
    }
    else if (el.compareTo(minimums[mintop])<0)
      minimums[++mintop] = el;
    else if (el.compareTo(maximums[maxtop])>0)
      maximums[++maxtop] = el;

    backing[++tos] = el;
  }

  public T pop() {
    if (isEmpty()) throw new EmptyStackException();
    if(minimums[mintop].equals(backing[tos])){
      mintop--;
    }
    else if (maximums[maxtop].equals(backing[tos])) {
      maxtop--;
    }
    return backing[tos--];
  }

  public T min() {
    if(isEmpty())
      throw new EmptyStackException();
    return minimums[mintop];
  }

  public T max() {
    if(isEmpty())
      throw new EmptyStackException();
    return maximums[maxtop];
  }

  public boolean isEmpty() {return tos==-1;}
}

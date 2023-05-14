package joshir.stack;

import java.util.EmptyStackException;
import java.util.Objects;

/*
* Simple min/max stack for any Comparable type using backing arrays
* with O(1) min or max lookups and O(N) extra space
* */
public class MinMaxStack<T extends Comparable<? super T>> {

  /* main backing store */
  private final T[] backing;

  /* store for mins*/
  private final T[] minimums;

  /* store for maxs*/
  private final T[] maximums;

  private int tos = -1;

  private int mintop = -1;

  private int maxtop = -1;

  public MinMaxStack() {
    this(20);
  }

  @SuppressWarnings("unchecked")
  public MinMaxStack (int size) {
    backing = (T[]) new Comparable<?>[size];
    minimums = (T[]) new Comparable<?>[size];
    maximums = (T[]) new Comparable<?>[size];
  }

  public void push(T el) {
    if (tos>=backing.length) throw new StackOverflowError();
    Objects.requireNonNull(el, "Argument must not be null");
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
    else if (minimums[mintop].equals(backing[tos])){
      mintop--;
    }
    else if (maximums[maxtop].equals(backing[tos])) {
      maxtop--;
    }
    return backing[tos--];
  }

  public T min() {
    if(isEmpty()) throw new EmptyStackException();
    return minimums[mintop];
  }

  public T max() {
    if(isEmpty()) throw new EmptyStackException();
    return maximums[maxtop];
  }

  public boolean isEmpty() {return tos==-1;}
}

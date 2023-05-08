package joshir.stacks;

import java.util.EmptyStackException;
import java.util.Iterator;


/*
* Simple min stack impl using a backing array
* */
public class MinStackOne<T extends Comparable<? super T>>{

  private final T[] backing;

  private final T[] minimums;

  private int min = -1;

  private int tos = -1;

  @SuppressWarnings("unchecked")
  public MinStackOne(int size) {
    backing = (T[]) new Comparable[size];
    minimums = (T[]) new Comparable[size];
  }

  public void push(T el) {
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

  public T pop() {
    if (tos<=-1) throw new EmptyStackException();
    if(minimums[min].equals(backing[tos])){
      min--;
    }
    return backing[tos--];
  }

  public T min() {
    if(tos==-1)
      throw new EmptyStackException();
    return minimums[min];
  }

  public boolean isEmpty() {return tos==-1;}
}




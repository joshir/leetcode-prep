package joshir.tree.heap;

import java.util.Comparator;
import java.util.Objects;

public class SimpleHeap<T extends Comparable<? super T>> {

  /* backing store for complete binary tree */
  private final T[] arr;

  /* track the next open position */
  private int next = 0;

  /* default size for backing store */
  private static final int defaultSize = 20;

  /*
   * if the default comparable behaviour is unacceptable,
   * override the comparator in the cons
   * */
  private Comparator<? super T> comparator = Comparator.naturalOrder();

  public SimpleHeap() {
    this(defaultSize);
  }

  @SuppressWarnings("unchecked")
  public SimpleHeap(int len) {
    arr = (T[]) new Comparable<?>[defaultSize];
  }

  public SimpleHeap(int len, Comparator<? super T> comparator ) {
    this(len);
    this.comparator = comparator;
  }

  public int left(int index) {
    if (index < 0 || index > arr.length/2) throw new IndexOutOfBoundsException();
    return 2 * index - 1;
  }

  public int right(int index) {
    if (index < 0 || index > arr.length/2) throw new IndexOutOfBoundsException();
    return 2 * index + 1;
  }

  public int parent(int index) {
    if (index < 0 || index > arr.length-1) throw new IndexOutOfBoundsException();
    return index / 2;
  }

  /*
  * add el in the correct position in the heap
  * in O(logn)
  * */
  public void add (T el) {
    Objects.requireNonNull(el, "Argument must not be null");
    if (next > arr.length - 1) throw new IndexOutOfBoundsException();

    arr[next++] = el;
    heapify(next -1);
  }

  /*
  * remove the highest priority element in the heap
  * in O(logn)
  * */
  public T remove() {
    T remove = arr[0];
    arr[0] = arr[--next];
    reverseHeapify(0);
    return remove;
  }

  /*
  * peek the highest priority element in the heap
  * */
  public T peek() {
    return arr[0];
  }

  /*
  * O(logn) mutation to maintain heap order after addition of
  * a new element
  * */
  private void heapify(int index ) {
    if (index == 0) return;
    T temp;
    int parent = parent(index);

    if(comparator.compare(arr[index], arr[parent]) > 0){
      temp = arr[index];
      arr[index] = arr[parent];
      arr[parent] = temp;
      heapify(parent);
    }
  }

  /*
   * O(logn) mutation to maintain heap order after removal
   * of the root element
   * */
  private void reverseHeapify(int index) {
    if(index > arr.length/2) return;
    int left = left(index), right = right(index), i;
    T temp = arr[index],
      tmin = comparator.compare(arr[left], arr[right]) > 0 ? arr[left]: arr[right];

    if(comparator.compare(arr[index], tmin) > 0) {
      arr[index] = tmin;
      tmin = temp;
      i = arr[left] == tmin ? left: right;
      reverseHeapify(i);
    }
  }
}

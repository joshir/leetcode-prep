package joshir.stack;

import java.util.LinkedList;

public class QueueViaTwoStacks<T> {

  /*
  * delegate to inner class
  * */
  DoubleStackQueue<T> dsq = new DoubleStackQueue<>();

  /*
  * incoming is a stack that accepts all incoming elements and
  * outgoing is a stack that accepts elements from the incoming
  * stack. order of insertion is maintained overall because
  * the first stack reverses the order and the second stack undoes the first.
  * */
  static class DoubleStackQueue<T>{

    /* incoming stack for insertions*/
    final LinkedList<T> incoming = new LinkedList<>();

    /* outgoing stack for extractions*/
    final LinkedList<T> outgoing = new LinkedList<>();

    void enque(T item) {
      incoming.add(item);
    }


    T deque() {
      drain();
      return outgoing.removeLast();
    }

    /*
     * make sure outgoing stack is empty before we add more elements to it
     * because we don't want to disrupt the order of older elements on the
     * outgoing stack with the new element from the incoming stack
     * */
    private void drain() {
      while(outgoing.isEmpty() && !incoming.isEmpty())
        outgoing.add(incoming.removeLast());
    }

    T peek() {
      drain();
      return outgoing.peekLast();
    }
  }

  void enque(T item) { dsq.enque(item);}

  T deque() {return dsq.deque();}

  T peek() {return dsq.deque();}
}

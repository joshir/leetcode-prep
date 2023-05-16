package joshir.stack;

import java.util.LinkedList;

public class QueueViaTwoStacks<T> {

  /*
  * delegate to inner class
  * */
  DoubleStackQueue<T> dsq = new DoubleStackQueue<>();

  static class DoubleStackQueue<T>{

    /* incoming stack for insertions */
    final LinkedList<T> incoming = new LinkedList<>();

    /* outgoing stack for extractions */
    final LinkedList<T> outgoing = new LinkedList<>();

    void enque(T item) {
      incoming.add(item);
    }

    /*
     * make sure outgoing stack is empty before we add more elements to it
     * because we don't want to disrupt the order of older elements on the
     * outgoing stack with the new element from the incoming stack
     * */
    T deque() {
      while(outgoing.isEmpty() && !incoming.isEmpty())
        outgoing.add(incoming.removeLast());
      return outgoing.removeLast();
    }

    T peek() {
      while(outgoing.isEmpty() && !incoming.isEmpty())
        outgoing.add(incoming.removeLast());
      return outgoing.peekLast();
    }
  }

  void enque(T item) { dsq.enque(item);}

  T deque() {return dsq.deque();}

  T peek() {return dsq.deque();}
}

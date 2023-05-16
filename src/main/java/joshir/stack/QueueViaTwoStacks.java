package joshir.stack;

import java.util.LinkedList;

public class QueueViaTwoStacks<T> {

  DoubleStackQueue<T> dsq = new DoubleStackQueue<>();

  static class DoubleStackQueue<T>{

    final LinkedList<T> s1 = new LinkedList<>();

    final LinkedList<T> s2 = new LinkedList<>();

    void enque(T item) {}

    T deque() {return null;}
  }

  void enque(T item) { dsq.enque(item);}

  T deque() {return dsq.deque();}
}

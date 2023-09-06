package com.joshir.ll;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintImmutableListInReverese {
  interface ImmutableListNode {
    void printValue(); // print the value of this node.
    ImmutableListNode getNext(); // return the next node.
  };
  public void printLinkedListInReverse(ImmutableListNode head) {
    if(head == null)
      return;
    printLinkedListInReverse(head.getNext());
    head.printValue();
  }


  public void printLinkedListInReverseWithAnActualStack(ImmutableListNode head) {
    Deque<ImmutableListNode> stack = new ArrayDeque<>();
    while (head != null) {
      stack.addLast(head);
      head = head.getNext();
    }

    while (!stack.isEmpty()) {
      ImmutableListNode node = stack.removeLast();
      node.printValue();
    }
  }
}

package com.joshir.ll;

public class RemoveLLElements {
  public ListNode removeElements(ListNode head, int val) {
    ListNode prevHead = new ListNode(0);
    prevHead.next = head;

    ListNode prev = prevHead, curr = head;
    while (curr != null) {
      if (curr.val == val) prev.next = curr.next;
      else prev = curr;
      curr = curr.next;
    }
    return prevHead.next;
  }
}

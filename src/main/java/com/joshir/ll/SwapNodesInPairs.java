package com.joshir.ll;

public class SwapNodesInPairs {
  class Solution {
    public ListNode swapPairs(ListNode head) {
      ListNode dummy = new ListNode(-1),prevNode = dummy;
      dummy.next = head;

      while (head != null&& head.next != null) {
        ListNode firstNode = head, secondNode = head.next;
        prevNode.next = secondNode;
        firstNode.next = secondNode.next;
        secondNode.next = firstNode;
        prevNode = firstNode;
        head = firstNode.next;
      }
      return dummy.next;
    }
  }
}

package com.joshir.ll;

public class SwapNodesInPairs {
  class Solution {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
    }
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

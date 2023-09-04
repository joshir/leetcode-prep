package com.joshir.ll;

public class ReverseLL {
  class Solutions {
    private ListNode newHead;
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
    }

    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null)
        return head;
      ListNode temp = reverseList(head.next);
      head.next.next = head;
      head.next = null;
      return temp;
    }

    public ListNode reverseListIter(ListNode head) {
      ListNode curr = head, prev = null, temp;
      while (curr != null) {
        temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }
      return prev;
    }
  }
}

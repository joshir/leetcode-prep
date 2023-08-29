package com.joshir.ll;

public class RotateList {
  class Solution {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
    }
    public ListNode rotateRight(ListNode head, int k) {
      if(k == 0 || head == null || head.next == null)
        return head;

      ListNode[] m = new ListNode[501];
      ListNode temp = head;
      int c = 0;
      while (temp != null) {
        m[c++] = temp;
        temp = temp.next;
      }

      k = k > c ? k%c: k;
      // check if k == 0 after recalibrating k
      if(k == 0)
        return head;

      // rotate right by k
      m[c-1].next = head;
      head = m[c-k];
      m[c-k-1].next = null;

      return head;
    }
  }
}

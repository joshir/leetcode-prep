package com.joshir.ll;

public class LinkedListCycle {
  class Solution {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
    }
    public boolean hasCycle(ListNode head) {
      ListNode slow = head, fast = head;

      while(fast != null && fast.next != null){
        fast = slow.next.next;
        slow = slow.next;
        if(slow == fast)
          return true;
      }
     return false;
    }
  }
}

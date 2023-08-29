package com.joshir.ll;

public class MiddleOfTheList {
  class Solution {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
    }

    public ListNode middleNode(ListNode head) {
      if(head == null || head.next == null)
        return head;
      /*
       * fast pointer moves 2n+1 from position 1 to 3 to 5 to 7 and so on
       * so fast pointer always overshoots end of an even sized list
       * */
      ListNode fast = head, mid = head;
      while(fast != null && fast.next != null ) {
        fast = fast.next.next;
        mid = mid.next;
      }

      return mid;
    }
  }
}

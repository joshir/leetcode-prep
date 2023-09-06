package com.joshir.ll;

public class LinkedListCycle {
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

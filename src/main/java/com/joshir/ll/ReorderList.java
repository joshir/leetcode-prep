package com.joshir.ll;

public class ReorderList {
  public void reorderList(ListNode head) {
    ListNode temp = null, mid = mid(head);
    ListNode  p1 = head, p2 = rev(mid.next);
    while(p1 != null && p2 != null){
      temp = p1.next;
      p1.next = p2;
      p1 = p2;
      p2 = temp;
    }
  }

  public ListNode mid(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }

    slow.next = null;
    return slow;
  }

  public ListNode rev(ListNode head){
    ListNode curr = head, prev = null, forward = null;
    while(curr!= null){
      forward = curr.next;
      curr.next = prev;
      prev = curr;
      curr = forward;
    }
    return prev;
  }
}

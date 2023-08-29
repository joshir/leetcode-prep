package com.joshir.ll;

public class DeleteMiddleNode {
  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
  }
  public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) return null;

    ListNode fast = head, mid = head, prevmid = head;

    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      prevmid = mid;
      mid = mid.next;
    }

    prevmid.next = mid.next;
    return head;
  }

  public static void main(String[] args) {
    ListNode l = new DeleteMiddleNode().deleteMiddle(new ListNode(1));
    System.out.println(l.val);
  }
}

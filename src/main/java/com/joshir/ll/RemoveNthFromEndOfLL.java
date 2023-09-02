package com.joshir.ll;

public class RemoveNthFromEndOfLL {
  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
  }

  public ListNode removeNthFromEndO1Space(ListNode head, int n) {
    ListNode start = new ListNode(-1);
    start.next = head;
    ListNode fast = start;
    ListNode slow = start;

    for(int i = 1; i <= n; ++i)
      fast = fast.next;

    while(fast.next != null)
    {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return start.next;
  }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null)
      return head;
    ListNode[] m = new ListNode[31]; // constraint sz is 30
    ListNode temp = head;
    int count = 0;
    while(temp != null){
      m[++count] = temp;
      temp = temp.next;
    }
    if(count > n)
      m[count-n].next = m[count-n+1].next;
    else if (count == n)
      head = head.next;
    return head;
  }
}

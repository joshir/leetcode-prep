package com.joshir.ll;

public class SortList {
  class Solution {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
    }
    public ListNode sortList(ListNode head) {
      if(head == null || head.next == null)
        return head;
      ListNode mid = middle(head);
      ListNode left = sortList(head);
      ListNode right = sortList(mid);

      return mergeLists(left, right);
    }

    public ListNode mergeLists(ListNode list1, ListNode list2) {
      ListNode head = new ListNode(-1);
      ListNode temp = head;

      while(list1 != null && list2 != null) {
        if(list1.val <= list2.val){
          temp.next = list1;
          list1 = list1.next;
        }else {
          temp.next = list2;
          list2 = list2.next;
        }
        temp = temp.next;
      }
      temp.next = list1 == null ? list2 : list1;
      return head.next;
    }

    public ListNode middle(ListNode head) {
      if(head == null || head.next == null)
        return head;

      ListNode mid = head, fast = head, prevmid = head;
      while(fast != null && fast.next != null) {
        fast = fast.next.next;
        prevmid = mid;
        mid = mid.next;
      }
      prevmid.next = null;
      return mid;
    }
  }
}

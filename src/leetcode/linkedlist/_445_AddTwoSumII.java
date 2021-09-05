package leetcode.linkedlist;

import test.structure.ListNode;

/*
 * You are given two non-empty linked lists representing two non-negative integers. The most
 * significant digit comes first and each of their nodes contains a single digit. Add the two
 * numbers and return the sum as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class _445_AddTwoSumII {
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */

      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          if (l1 == null) return l2;
          if (l2 == null) return l1;
          ListNode tmp1 = l1;
          ListNode tmp2 = l2;
          int length1 = 1, length2 = 1;
          while (tmp1.next != null) {
              tmp1 = tmp1.next;
              length1++;
          }
          while (tmp2.next != null) {
              tmp2 = tmp2.next;
              length2++;
          }
          if (length2 > length1) {
              return addTwoNumbers(l2, l1, length2, length1);
          } else {
              return addTwoNumbers(l1, l2, length1, length2);
          }
      }
      
      public ListNode addTwoNumbers(ListNode l1, ListNode l2, int length1, int length2) {
          ListNode head1 = new ListNode(); head1.next = l1;
          ListNode head2 = new ListNode(); head2.next = l2;
          ListNode resultHead = new ListNode();
          int diff = length1 - length2;
          ListNode cur1 = l1; ListNode cur2 = l2;
          while (diff > 0) {
              ListNode tmpNode = new ListNode(cur1.val);
              tmpNode.next = resultHead.next;
              resultHead.next = tmpNode;
              cur1 = cur1.next;
              diff--;
          }
          while (cur1 != null) {
              int sum = cur1.val + cur2.val;
              ListNode tmpNode = new ListNode(sum);
              tmpNode.next = resultHead.next;
              resultHead.next = tmpNode;
              cur1 = cur1.next; cur2 = cur2.next;
          }
          //reverse resultList
          return reverseList(resultHead);
          
          
      }
      
      public ListNode reverseList(ListNode head) {
          ListNode resultHead = new ListNode();
          ListNode cur = head.next;
          int prefix = 0;
          while (cur != null) {
              ListNode tmpNode = new ListNode(cur.val + prefix);
              if (tmpNode.val >= 10) {
                  tmpNode.val -= 10;
                  prefix = 1;
              } else
                  prefix = 0;
              tmpNode.next = resultHead.next;
              resultHead.next = tmpNode;
              cur = cur.next;
          }
          if (prefix == 1) {
              ListNode tmpNode = new ListNode(1);
              tmpNode.next = resultHead.next;
              resultHead.next = tmpNode;
          }
          return resultHead.next;
      }
  
}

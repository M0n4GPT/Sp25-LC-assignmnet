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
class Solution {
    /**
    * basic ideas:
    * find mid and split into two lists
    * reverse the second linkedlist
    * merge two lists
    */
    public void reorderList(ListNode head) {
        ListNode cur = findmid(head);
        ListNode mid = cur.next;
        cur.next=null;
        ListNode rev = reverseList(mid);
        merge(head,rev);
    }

    public ListNode findmid(ListNode head){
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode prev = head,cur = head.next;
        prev.next=null;
        ListNode next = null;
        while(cur.next!=null){
            next = cur.next;
            cur.next=prev;
            prev = cur;
            cur = next;
        }
        cur.next=prev;
        return cur;
    }
    public void merge(ListNode l1, ListNode l2){
        ListNode temp1;
        ListNode temp2;
        while(l1!=null&&l2!=null){
            temp1 = l1.next;
            temp2 = l2.next;
            l1.next=l2;
            l1=temp1;
            l2.next=l1;
            l2=temp2;
        }
    }

}

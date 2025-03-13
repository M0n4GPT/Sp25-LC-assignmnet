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
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> ary = new ArrayList<Integer>();
        while(cur!=null){
            ary.add(cur.val);
            cur=cur.next;
        }
        int length = ary.size();
        int left=0,right=length-1;
        while(left<=right){
            if (ary.get(left)==ary.get(right)) {
                left++;
                right--;
                continue;
            }
            else return false;
        }
        return true;
    }
}

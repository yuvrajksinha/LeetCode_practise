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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        for(int i=1;i<left;i++){
            prev=curr;
            curr=curr.next;
        }
        ListNode p=null;
        for(int i=left;i<=right;i++){ 
            ListNode next=curr.next;
            curr.next=p;
            p=curr;
            curr=next;
        }
        (prev.next).next=curr;
        prev.next=p;
        return dummy.next;
    }
}
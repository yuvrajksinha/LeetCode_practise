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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode curr = head;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        if(count==n){
            return head.next;
        }
        curr=head;
        for(int i=1;i<count-n;i++){
            curr=curr.next;
        }
        curr.next=(curr.next).next;
        return head;
    }
}
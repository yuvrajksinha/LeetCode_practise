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
    public void reorderList(ListNode head) {
        if(head.next==null){
            return;
        }

        //Find Middle of List
        ListNode turtle = head;
        ListNode hare = head;
        while(hare!=null && hare.next!=null){
            hare = hare.next.next;
            turtle=turtle.next;
        }

        //reverse the second half of the list
        ListNode prev=null;
        ListNode curr=turtle;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        //make two pointers to go through lists and join them
        ListNode firstListNode=head;
        ListNode secondListNode=prev;
        while(secondListNode.next!=null){
            ListNode tempNext=firstListNode.next;
            firstListNode.next=secondListNode;
            firstListNode=tempNext;

            tempNext = secondListNode.next;
            secondListNode.next=firstListNode;
            secondListNode=tempNext;
        }
    }
}
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); //dummy list for no null pointer exceptions
        ListNode curr = dummy; //point the pointer to this new list head
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int x=(l1!=null)?l1.val:0; //if there is a val then add that otherwise have 0
            int y=(l2!=null)?l2.val:0;
            int sum = x+y+carry; //both the values get added with the previous carry 
            carry = sum/10; //we get the new carry that will be used in the next iteration
            curr.next = new ListNode(sum%10); //curr node point to new node with the last digit of sum
            curr=curr.next; //take the pointer to that 
            if(l1!=null){ //if l1!=null we go to the next node 
                l1=l1.next;
            }
            if(l2!=null){ //same here
                l2=l2.next;
            }
        }
        return dummy.next; //return the next node as the head of the new list
    }
}
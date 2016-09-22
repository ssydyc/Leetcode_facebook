/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // count the number of Nodes in the List
        int n = 0;
        ListNode cur = head;
        while(cur != null) {
            n++;
            cur = cur.next;
        }
        
        // initilize head of new List
        if(n < k || k <= 1) return head;
        ListNode newHead = null;
        
        // reverse LinkedList for each k nodes
        ListNode newTail = new ListNode(0);
        ListNode nextHead = head;
        while(n >= k) {
            cur = nextHead;
            ListNode prev = null;
            for(int i = 0; i < k; i++) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            
            if(newHead == null) {
                newHead = prev;
            }
            newTail.next = prev;
            newTail = nextHead;
            nextHead = cur;
            n -= k;
        }
        newTail.next = nextHead;
        
        return newHead;
    }
}

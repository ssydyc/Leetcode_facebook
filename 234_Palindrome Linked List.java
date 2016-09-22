/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        // get length of list
        int n = 0;
        ListNode cur = head;
        while(cur != null) {
            n++;
            cur = cur.next;
        }
        
        // reverse first half of LinkedList
        cur = head;
        ListNode prev = null;
        for(int i = 0; i < n/2; i++) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        // check whehter it's palindrome
        ListNode head1 = cur;
        ListNode head2 = prev;
        if(n % 2 != 0) {
            head1 = head1.next;
        }
        while(head1 != null) {
            if(head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
    }
}

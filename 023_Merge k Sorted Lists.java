/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        ListNode nil = new ListNode(0);
        
        // create heap
        PriorityQueue<ListNode> nodeHeap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
           public int compare(ListNode node1, ListNode node2) {
               return node1.val - node2.val;
           }
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                nodeHeap.offer(lists[i]);
            }
        }
        
        // get sorted result
        ListNode cur = nil;
        while (nodeHeap.size() > 0) {
            ListNode temp = nodeHeap.poll();
            if (temp.next != null) {
                nodeHeap.offer(temp.next);
            }
            
            cur.next = temp;
            cur = temp;
        }
        
        return nil.next;
    }
}

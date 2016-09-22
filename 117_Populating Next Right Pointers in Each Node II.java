/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        root.next = null;
        TreeLinkNode leftmost = root;
        
        while(leftmost != null) {
            // initilize nodes for the current level
            TreeLinkNode curThisLevel = leftmost;
            TreeLinkNode prev = null;
            leftmost = null;
            
            // connect all nodes of next level
            while(curThisLevel != null) {
                if(curThisLevel.left != null) {
                    if(prev != null){
                        prev.next = curThisLevel.left;
                    }
                    prev = curThisLevel.left;
                }
                if(leftmost == null) {
                    leftmost = prev;
                }
                
                if(curThisLevel.right != null) {
                    if(prev != null) {
                        prev.next = curThisLevel.right;
                    }
                    prev = curThisLevel.right;
                }
                if(leftmost == null) {
                    leftmost = prev;
                }
                
                if(prev != null) {
                    prev.next = null;
                }
                
                curThisLevel = curThisLevel.next;
            }
            
        }
    }
}

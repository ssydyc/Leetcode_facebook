/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        
        while(root != null) {
            if(root.val > q.val) {
                root = root.left;
            }
            else if(root.val <= q.val && root.val >= p.val) {
                return root;
            }
            else {
                root = root.right;
            }
        }
        
        return root;
    }
}

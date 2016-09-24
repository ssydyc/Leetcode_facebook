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
    private void pathHelper(TreeNode root, List<String> res, StringBuilder candidate) {
        if (root.left == null && root.right == null) {
            res.add(candidate.toString());
            return;
        }
        
        // add left and right node
        if (root.left != null) {
            String numToAdd = String.valueOf(root.left.val);
            candidate.append("->" + String.valueOf(numToAdd));
            pathHelper(root.left, res, candidate);
            candidate.delete(candidate.length() - 2 - numToAdd.length(),candidate.length());
        }
        
        if (root.right != null) {
            String numToAdd = String.valueOf(root.right.val);
            candidate.append("->" + String.valueOf(numToAdd));
            pathHelper(root.right, res, candidate);
            candidate.delete(candidate.length() - 2 - numToAdd.length(),candidate.length());
        }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        
        StringBuilder candidate = new StringBuilder();
        candidate.append(String.valueOf(root.val));
        
        pathHelper(root, res, candidate);
        
        return res;
    }
}

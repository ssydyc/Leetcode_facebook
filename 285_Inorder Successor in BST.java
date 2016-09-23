/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    TreeNode resNode;
    boolean pFound; 
    
    public ResultType() {
        resNode = null;
        pFound = false;
    }
} 

public class Solution {
    private void successorHelper(TreeNode root, TreeNode p, ResultType res) {
        if (root == null) {
            return;
        }
        
        successorHelper(root.left, p, res);
        
        if (res.pFound == false) {
            res.pFound = (root == p);
        } else if (res.resNode == null) {
            res.resNode = root;
        }
        
        successorHelper(root.right, p, res);
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ResultType res = new ResultType();
        successorHelper(root, p, res);
        return res.resNode;
    }
}

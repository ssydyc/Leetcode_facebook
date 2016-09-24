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
    boolean pqFound;
    TreeNode resNode;
    
    public ResultType(boolean pqFound, TreeNode resNode) {
        this.pqFound = pqFound;
        this.resNode = resNode;
    }
}
 
public class Solution {
    private ResultType LcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new ResultType(false, null);
        }
        
        ResultType leftResult = LcaHelper(root.left, p, q);
        ResultType rightResult = LcaHelper(root.right, p, q);
        
        if (root == p || root == q) {
            if (leftResult.pqFound || rightResult.pqFound) {
                return new ResultType(true, root);
            } else {
                return new ResultType(true, null);
            }
        } else {
            if (leftResult.pqFound && rightResult.pqFound) {
                return new ResultType(true, root);
            } else if (leftResult.pqFound) {
                return leftResult;
            } else {
                return rightResult;
            }
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ResultType res = LcaHelper(root, p, q);
        return res.resNode;
    }
}

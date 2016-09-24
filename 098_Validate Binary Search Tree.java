/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class ResultType {
    int minValue;
    int maxValue;
    boolean isBst;
    
    public ResultType(int minValue, int maxValue, boolean isBst) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.isBst = isBst;
    }
} 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private ResultType validBstHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        ResultType leftResult = validBstHelper(root.left);
        ResultType rightResult = validBstHelper(root.right);
        
        // BST or not
        boolean curBST = true;
        int minValue = root.val;
        int maxValue = root.val;
        
        if (leftResult != null) {
            if (!leftResult.isBst || leftResult.maxValue >= root.val) {
                curBST = false;
            } else {
                minValue = leftResult.minValue;
            }
        }
        
        if (rightResult != null) {
            if (!rightResult.isBst || rightResult.minValue <= root.val) {
                curBST = false;
            } else {
                maxValue = rightResult.maxValue;
            }
        }
        
        return new ResultType(minValue, maxValue, curBST);
    }
    
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        return validBstHelper(root).isBst;
    }
}

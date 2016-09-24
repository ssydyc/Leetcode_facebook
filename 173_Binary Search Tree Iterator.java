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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    //@param root: The root of binary tree.
    Stack<TreeNode> iterateSk;
    
    public BSTIterator(TreeNode root) {
        // write your code here
        iterateSk = new Stack<TreeNode>();
        while (root != null) {
            iterateSk.push(root);
            root = root.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !iterateSk.empty();
    }
    
    //@return: return next node
    public int next() {
        // write your code here
        TreeNode res = iterateSk.pop();
        
        TreeNode cur = res;
        if (cur.right != null) {
            iterateSk.push(cur.right);
            cur = cur.right;
            while (cur.left != null) {
                iterateSk.push(cur.left);
                cur = cur.left;
            }
        }
        
        return res.val;
    }
}

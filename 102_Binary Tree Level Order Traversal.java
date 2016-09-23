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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);
        
        while (nodeQueue.size() > 0) {
            int numNodes = nodeQueue.size();
            List<Integer> curLevel = new ArrayList<Integer>();
            
            for (int i = 0; i < numNodes; i++) {
                TreeNode curNode = nodeQueue.poll();
                curLevel.add(curNode.val);
                
                if (curNode.left != null) {
                    nodeQueue.add(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.add(curNode.right);
                }
            }
            
            res.add(curLevel);
        }
        
        return res;
    }
}

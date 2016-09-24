/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PositionNode {
    int pos;
    TreeNode node;
    
    public PositionNode (int pos, TreeNode node) {
        this.pos = pos;
        this.node = node;
    }
}
 
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        
        // initialize variables
        HashMap<Integer, List<Integer>> posNodeMap = new HashMap<Integer, List<Integer>>();
        Queue<PositionNode> posNodeQueue = new LinkedList<PositionNode>();
        
        // BFS the tree
        posNodeQueue.offer(new PositionNode(0, root));
        while (posNodeQueue.size() > 0) {
            int size = posNodeQueue.size();
            
            for (int i = 0; i < size; i++) {
                PositionNode cur = posNodeQueue.poll();
                if (posNodeMap.containsKey(cur.pos)) {
                    posNodeMap.get(cur.pos).add(cur.node.val);
                } else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(cur.node.val);
                    posNodeMap.put(cur.pos, temp);
                }
                
                if (cur.node.left != null) {
                    posNodeQueue.offer(new PositionNode(cur.pos - 1, cur.node.left));
                }
                
                if (cur.node.right != null) {
                    posNodeQueue.offer(new PositionNode(cur.pos + 1, cur.node.right));
                }
            }
        }
        
        // Get the minimum position
        int curPos = Integer.MAX_VALUE;
        for (int i : posNodeMap.keySet()) {
            curPos = Math.min(curPos, i);
        }
        
        // return result
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while (posNodeMap.containsKey(curPos)) {
            res.add(posNodeMap.get(curPos++));
        }
        
        return res;
    }
}

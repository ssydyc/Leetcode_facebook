/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        
        while (nodeQueue.size() > 0) {
            int size = nodeQueue.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode cur = nodeQueue.poll();
                if (cur == null) {
                    res.append("n" + ",");
                } else {
                    res.append(String.valueOf(cur.val) + ",");
                    nodeQueue.offer(cur.left);
                    nodeQueue.offer(cur.right);
                }
            }
        }
        
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        if(nodeValues[0].equals("n")) {
            return null;
        }
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(nodeValues[0]));
        nodeQueue.offer(root);
        int curIndex = 1;
        
        while (nodeQueue.size() > 0) {
            int size = nodeQueue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (curNode == null) {
                    continue;
                } else {
                    TreeNode leftNode = nodeValues[curIndex].equals("n") ? null : new TreeNode(Integer.valueOf(nodeValues[curIndex]));
                    curIndex++;
                    TreeNode rightNode = nodeValues[curIndex].equals("n") ? null : new TreeNode(Integer.valueOf(nodeValues[curIndex]));
                    curIndex++;
                    curNode.left = leftNode;
                    curNode.right = rightNode;
                    nodeQueue.offer(leftNode);
                    nodeQueue.offer(rightNode);
                }
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

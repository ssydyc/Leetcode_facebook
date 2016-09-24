/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> nodesRecord = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode res = null;
        
        if (node == null) {
            return res;
        }
        
        Queue<UndirectedGraphNode> nodeQueue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        nodeQueue.offer(node);
        visited.add(node);
        
        while (nodeQueue.size() > 0) {
            int size = nodeQueue.size();
            
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode curNode = nodeQueue.poll();
                
                // add the copyNode if not there
                if (!nodesRecord.containsKey(curNode.label)) {
                    nodesRecord.put(curNode.label, new UndirectedGraphNode(curNode.label));
                }
                UndirectedGraphNode copyNode = nodesRecord.get(curNode.label);
                
                // record the first node;
                if (res == null) {
                    res = copyNode;
                }
                
                // add neighbors
                for (UndirectedGraphNode nextNode : curNode.neighbors) {
                    if (!visited.contains(nextNode)) {
                        nodeQueue.offer(nextNode);
                        visited.add(nextNode);
                    }
                    
                    if (nodesRecord.containsKey(nextNode.label)) {
                        copyNode.neighbors.add(nodesRecord.get(nextNode.label));
                    } else {
                        nodesRecord.put(nextNode.label, new UndirectedGraphNode(nextNode.label));
                        copyNode.neighbors.add(nodesRecord.get(nextNode.label));
                    }
                }
            }
        }
        
        return res;
    }
}

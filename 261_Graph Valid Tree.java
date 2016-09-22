public class Solution {
    private int findRoot(int[] unionSet, int node) {
        while (unionSet[node] != node) {
            node = unionSet[node];
        }
        
        return node;
    }
    
    public boolean validTree(int n, int[][] edges) {
        // connected with n-1 edges will be a tree, cycle can be checked by ideas of Union Set
        if (edges.length != n - 1) {
            return false;
        }
        
        int[] unionSet = new int[n];
        
        for (int i = 0; i < n; i++) 
            unionSet[i] = i;
            
        for (int i = 0; i < edges.length; i++) {
            int root1 = findRoot(unionSet, edges[i][0]);
            int root2 = findRoot(unionSet, edges[i][1]);
            if (root1 == root2) {
                return false;
            } else if (root1 > root2) {
                unionSet[root1] = root2;
            } else {
                unionSet[root2] = root1;
            }
        }
        
        return true;
        
    }
}

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // generate graphs represented by linkedList (each node with linkedlists with the course as prerequisites)
        List<ArrayList<Integer>> preGraph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            preGraph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            preGraph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        // calculate inDegrees
        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegrees[prerequisites[i][0]]++;
        }
        
        // topological sorting with DFS
        Stack<Integer> candidate = new Stack<Integer>();
        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0) {
                candidate.push(i);
            }
        }
        
        int[] res = new int[numCourses];
        int curPos = 0;
        
        while(candidate.size() > 0) {
            int curRemove = candidate.pop();
            res[curPos++] = curRemove;
            
            for (Integer nextNode : preGraph.get(curRemove)) {
                inDegrees[nextNode]--;
                if (inDegrees[nextNode] == 0) {
                    candidate.push(nextNode);
                }
            }
        }
        
        // return result as Array
        if(curPos < numCourses){
            int[] resArray = {};
            return resArray;
        }
        else{
            return res;
        }
        
    }
}

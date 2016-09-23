public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<int[]> res = new ArrayList<int[]>();
        
        if (n == 0) {
            return res;
        }
        
        // get the results of right end of buildings
        int[] rightEnds = new int[n];
        for (int i = 0; i < n; i++) {
            rightEnds[i] = buildings[i][1];
        }
        Arrays.sort(rightEnds);
        
        // initialize the PriorityQueue 
        PriorityQueue<int[]> curBuildings = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
            public int compare(int[] building1 ,int[] building2) {
                return building2[2] - building1[2];
            }
        });
        
        // now get skyLine
        int leftEndIndex = 0;
        int rightEndIndex = 0;
        while (leftEndIndex != n || rightEndIndex != n) {
            // we are considering the start of a building
            if (rightEndIndex == n || (leftEndIndex != n && rightEnds[rightEndIndex] > buildings[leftEndIndex][0])) {
                curBuildings.offer(buildings[leftEndIndex]);
                
                int[] tempRes = {buildings[leftEndIndex][0], curBuildings.peek()[2]};
                
                res.add(tempRes);
                leftEndIndex++;
            } 
            
            // considering end of a building  
            else {
                while (curBuildings.size() > 0 && curBuildings.peek()[1] <= rightEnds[rightEndIndex]) {
                    curBuildings.poll();
                }
                
                int[] tempRes = {rightEnds[rightEndIndex], 0};
                if (curBuildings.size() > 0) {
                    tempRes[1] = curBuildings.peek()[2];
                }
                
                res.add(tempRes);
                rightEndIndex++;
            }
        }
        
        // filter res
        List<int[]> filterRes = new ArrayList<int[]>();
        for (int i = 0; i < res.size(); i++) {
            System.out.println(String.valueOf(res.get(i)[0]) + String.valueOf(',') + String.valueOf(res.get(i)[1]));
            if (i > 0 && res.get(i)[0] == res.get(i - 1)[0]) {
                filterRes.get(filterRes.size() - 1)[1] = Math.max(res.get(i)[1], filterRes.get(filterRes.size() - 1)[1]);
            } else {
                filterRes.add(res.get(i));
            }
        }
        
        // filter same height;
        int size = filterRes.size();
        for (int i = size - 1; i > 0; i--) {
            if (filterRes.get(i)[1] == filterRes.get(i - 1)[1]) {
                filterRes.remove(i);
            }
        }
        
        return filterRes;
    }
}

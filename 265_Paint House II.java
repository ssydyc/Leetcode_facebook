public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        
        int n = costs.length, k = costs[0].length;
        int curFirstMin = -1, curSecondMin = -1;
        int prevFirstMin = -1, prevSecondMin = -1;
        
        for (int house = 0; house < n; house++) {
            for (int color = 0; color < k; color++){
                // update the minimum cost after painting current house
                if(prevFirstMin != -1){
                    if(prevFirstMin != color){
                        costs[house][color] += costs[house - 1][prevFirstMin];
                    }
                    else{
                        costs[house][color] += costs[house - 1][prevSecondMin];   
                    }
                }
                
                //update the current first Min value of costs and second min value
                if(curSecondMin == -1 || costs[house][curSecondMin] > costs[house][color]) {
                    curSecondMin = color;
                }
                if(curFirstMin == -1 || costs[house][curFirstMin] > costs[house][curSecondMin]){
                    int temp = curSecondMin;
                    curSecondMin = curFirstMin;
                    curFirstMin = temp;
                }
            }
            
            prevFirstMin = curFirstMin;
            prevSecondMin = curSecondMin;
            curFirstMin = curSecondMin = -1;
        }
        
        return costs[n-1][prevFirstMin];
    }
}

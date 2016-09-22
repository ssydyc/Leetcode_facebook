public class Solution {
    private int maxNum(int x, int y, int[][] numOnesFollow) {
        int m = numOnesFollow.length, n = numOnesFollow[0].length;
        
        int maxResult = 0;
        int maxRows = Integer.MAX_VALUE;
        
        for(int columns = 1; y + columns - 1 < n && numOnesFollow[x][y + columns - 1] > 0; columns++) {
            maxRows = Math.min(maxRows, numOnesFollow[x][y + columns - 1]);
            int recArea = maxRows * columns;
            maxResult = recArea > maxResult? recArea: maxResult; 
        }
        
        return maxResult;
    }
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        
        // create number of ones following in the column
        int[][] numOnesFollow = new int[m][n];
        for(int j = 0; j < n; j++) {
            int numOnes = 0;
            for(int i = m - 1; i >= 0; i--) {
                if(matrix[i][j] == '1') {
                    numOnes++;
                    numOnesFollow[i][j] = numOnes;
                }
                else {
                    numOnesFollow[i][j] = 0;
                    numOnes = 0;
                }
            }
        }
        
        // calculate the maxnum of ones
        int maxNumOnes = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j ++) {
                maxNumOnes = Math.max(maxNumOnes, maxNum(i, j, numOnesFollow));
            }
        }
        
        return maxNumOnes;
    } 
}

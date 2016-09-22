public class Solution {
    private void updateMaxSquare(int[][] matrix, int x, int y) {
         int m = matrix.length, n = matrix[0].length;
         int curMax = matrix[x][y];
         
         for(int i = curMax + 1; x + i < m + 1 && y + i < n + 1; i++) {
             boolean stopFind = false;
             for(int j = 0; j < i; j++) {
                 if(matrix[x + curMax][y + j] == 0 || matrix[x + j][y + curMax] == 0) {
                     stopFind = true;
                     break;
                 }
             }
             
             if(stopFind){
                 break;
             }
             curMax++;
         }
         
         matrix[x][y] = curMax;
    }
    
    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0;
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        
        int[][] intMatrix = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                intMatrix[i][j] = matrix[i][j] == '0'? 0: 1;       
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(intMatrix[i][j] > 0) {
                    if(i > 0) {
                        intMatrix[i][j] = Math.max(1, intMatrix[i - 1][j] - 1);
                    }
                    if(j > 0) {
                        intMatrix[i][j] = Math.max(1, intMatrix[i][j - 1] - 1);
                    }
                    if(i > 0 && j > 0) {
                        intMatrix[i][j] = Math.max(1, intMatrix[i - 1][j - 1] - 1);
                    }
                    
                    updateMaxSquare(intMatrix, i, j);
                    
                    if(intMatrix[i][j] > maxSquare) {
                        maxSquare = intMatrix[i][j];
                    }
                }
            }
        }
        
        return maxSquare * maxSquare;
    }
}

public class Solution {
    private void DFS(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >=n) {
            return;
        }
        
        if (grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }
        
        grid[i][j] = '2';
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < directions.length; k++) {
            DFS(grid, i + directions[k][0], j + directions[k][1]);
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, i ,j);
                    numIslands++;
                }
            }
        }
        
        return numIslands;
    }
}

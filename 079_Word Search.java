public class Solution {
    private boolean existHelper(char[][] board, String word, int curStrLoc, int[] cur, HashSet<Integer> visited) {
        int m = board.length;
        int n = board[0].length;
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        if (word.charAt(curStrLoc) != board[cur[0]][cur[1]]) {
            return false;
        }
        
        if (++curStrLoc == word.length()) {
            return true;
        }
        
        for (int i = 0; i < direction.length; i++) {
            int[] next = new int[]{cur[0] + direction[i][0], cur[1] + direction[i][1]};
            
            if (!visited.contains(next[0] * n + next[1]) && next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n) {
                visited.add(next[0] * n + next[1]);
                
                if (existHelper(board, word, curStrLoc, next, visited)) {
                    return true;
                }
                
                visited.remove(next[0] * n + next[1]);
            }
        }
        
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        if (m == 0) {
            return false;
        }
        
        if (word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                HashSet<Integer> visited = new HashSet<Integer>();
                int[] cur = {i, j};
                visited.add(cur[0] * n + cur[1]);
                if (existHelper(board, word, 0, cur, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

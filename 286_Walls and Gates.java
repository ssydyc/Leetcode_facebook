public class Solution {
    private void BFS(int starti, int startj, int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{starti, startj});
        int[] addx = {-1 , 1, 0, 0};
        int[] addy = {0, 0, -1, 1};
        
        int level = 0;
        while(q.size() > 0) {
            level++;
            int qsize = q.size();
            for(int i = 0; i < qsize; i++) {
                int[] cur = q.poll();
                for(int j = 0; j < 4; j ++) {
                    int nextx = cur[0] + addx[j];
                    int nexty = cur[1] + addy[j];
                    if(nextx >= 0 && nexty >= 0 && nextx < m && nexty < n && rooms[nextx][nexty] > 0) {
                        if(rooms[nextx][nexty] > level) {
                            q.add(new int[]{nextx, nexty});
                            rooms[nextx][nexty] = level;
                        }
                    }
                }
            }
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    BFS(i, j, rooms);
                }
            }
        }
    }
}

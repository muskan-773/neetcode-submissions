class Solution {
    class Pair{
        int row;
        int col;
        int tm;
        Pair(int row, int col, int tm){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        
        int countFresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } 
                else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        int tm = 0;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};
        int count = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;

            tm = Math.max(tm, t);
            q.remove();

            for (int i = 0; i < 4; i++) {

                int nx = r + drow[i];
                int ny = c + dcol[i];

                if (nx >= 0 && ny >= 0 &&
                    nx < m && ny < n &&
                    grid[nx][ny] == 1 &&
                    vis[nx][ny] == 0) {

                    q.add(new Pair(nx, ny, t + 1));

                    vis[nx][ny] = 2;

                    count++;
                }
            }
        }
        if(countFresh != count) return -1;
        return tm;
    }
}
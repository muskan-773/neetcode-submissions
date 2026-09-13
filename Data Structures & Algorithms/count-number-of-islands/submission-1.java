class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }

        return count;
    }

    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] vis){
        int m = grid.length, n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));
        vis[i][j] = true;

        while(q.size() > 0){

            Pair front = q.remove();
            int row = front.row, col = front.col;

            int[] dRow = {-1, 1, 0, 0};
            int[] dCol = {0, 0, -1, 1};

            for(int k = 0; k < 4; k++){

                int nRow = row + dRow[k];
                int nCol = col + dCol[k];

                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && 
                grid[nRow][nCol] == '1' && !vis[nRow][nCol]){

                    vis[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol));
                }
                
            }
        }
    }
}
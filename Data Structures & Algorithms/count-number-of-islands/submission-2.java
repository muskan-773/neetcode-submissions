class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(i, j, grid, vis);
                    count++;
                }
            }
        }

        return count;
    }
    private void dfs(int i, int j, char[][] grid, boolean[][] vis){
        int m = grid.length, n = grid[0].length;
        vis[i][j] = true;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for(int k = 0; k < 4; k++){

            int nRow = i + dRow[k];
            int nCol = j + dCol[k];
            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && 
            grid[nRow][nCol] == '1' && !vis[nRow][nCol]){
                vis[nRow][nCol] = true;
                dfs(nRow, nCol, grid, vis);
                
            }
        }
    }
}
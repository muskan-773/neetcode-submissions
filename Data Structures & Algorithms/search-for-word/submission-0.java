class Solution {
    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, vis, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] vis, int i, int j, int idx){

        if(idx == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }

        if(vis[i][j] || board[i][j] != word.charAt(idx)){
            return false;
        }

        vis[i][j] = true;

        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        for(int dir = 0;dir < 4;dir++){

            int nx = i + drow[dir];
            int ny = j + dcol[dir];

            if(dfs(board, word, vis, nx, ny, idx + 1)){
                return true;
            }
        }

        vis[i][j] = false;

        return false;
    }
}
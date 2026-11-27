class Solution {

    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(char[][] grid , int r , int c) {
        if(r < 0 || r >=grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for(int[] dir : directions) {
            int row = r+dir[0],col = c+dir[1];
            dfs(grid,row,col);
        }
    }
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    res++;
                }
                
            }
        }
        return res;
    }
}

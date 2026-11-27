class Solution {

    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public  void bfs(char[][] grid,int i,int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        grid[i][j] = '0';
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0],c = pos[1];
            for(int[] dir : directions) {
                int row = r + dir[0],col = c+dir[1];
                if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1') {
                    queue.offer(new int[]{row,col});
                    grid[row][col] = '0';
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    bfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
}

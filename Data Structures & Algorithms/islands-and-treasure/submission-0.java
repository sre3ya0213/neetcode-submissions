class Solution {

    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0], c = node[1];
            for(int[] dir : directions) {
                int row = r+dir[0] , col = c+dir[1];
                if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == Integer.MAX_VALUE) {
                    grid[row][col] = grid[r][c] + 1;
                    q.offer(new int[]{row,col});
                }
            }
        }
    }
}

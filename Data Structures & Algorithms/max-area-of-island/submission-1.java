class Solution {
    public int bfs(int[][] grid,int r,int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        int curArea = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] pos = queue.poll();
                int row = pos[0];
                int col = pos[1];
                if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
                    continue;
                }
                else {
                    curArea+=1;
                    grid[row][col] = 0;
                    queue.offer(new int[]{row+1,col});
                    queue.offer(new int[]{row-1,col});
                    queue.offer(new int[]{row,col+1});
                    queue.offer(new int[]{row,col-1});
                }
            }
        }
        return curArea;
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int area = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    area = Math.max(bfs(grid,i,j),area);
                }
            }
        }
        return area;
    }
}
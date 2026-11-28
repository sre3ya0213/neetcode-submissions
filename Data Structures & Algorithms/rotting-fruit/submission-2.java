class Solution {

    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] node = q.poll();
                int r = node[0],c=node[1];
                for(int[] dir : directions) {
                    int row = r + dir[0], col = c+dir[1];
                    if(row >=0 && col >=0 && row<grid.length && col<grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row,col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh==0 ? time : -1;
        
    }
}

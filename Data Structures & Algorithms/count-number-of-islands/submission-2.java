class Solution {
    
    public void bfs(char[][] grid,int row,int col) {
       Queue<int[]> queue = new LinkedList<>();
       queue.offer(new int[]{row,col});
       while(!queue.isEmpty()) {
         int size = queue.size();
         for(int i=0;i<size;i++) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
                continue;
            }
            else {
                grid[r][c] = '0';
                queue.offer(new int[]{r+1,c});
                queue.offer(new int[]{r-1,c});
                queue.offer(new int[]{r,c-1});
                queue.offer(new int[]{r,c+1});
            } 
         }
       }
     
    }
    public int numIslands(char[][] grid) {
        int island = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    island++;
                    bfs(grid,i,j);
                }
            }
        }
        return island;
        
    }
}


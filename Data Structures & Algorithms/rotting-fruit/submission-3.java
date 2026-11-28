class Solution {
    
    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int fresh = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while(fresh > 0) {
            boolean flag = false;
            for(int i=0;i<grid.length;i++) {
                for(int j=0;j<grid[i].length;j++) {
                    if(grid[i][j] == 2) {
                        for(int[] dir : directions) {
                            int row = i + dir[0], col = j + dir[1];
                            if(row >=0 && col >=0 && row<grid.length && col<grid[0].length && grid[row][col] == 1) {
                                grid[row][col] = 3;
                                fresh--;
                                flag = true;
                            }
                        }
                    }
                }
            }
            if(!flag) return -1;

            for(int i=0;i<grid.length;i++) {
                for(int j=0;j<grid[i].length;j++) {
                    if(grid[i][j] == 3) {
                        grid[i][j] = 2;
                    }
                }
            }
            time++;
        }
        return time;
    }
}


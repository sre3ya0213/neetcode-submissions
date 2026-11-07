class Solution {
    List<List<String>> res;
    char[][] placed;
    boolean[] cols,posDiag,negDiag;
    public boolean isSafe(int n,int row , int col) {
        if(cols[col] || posDiag[row+col] || negDiag[row-col+n]) {
            return false;
        }
        return true;
    }
    public void backtrack(int n,int row) {
        if(row == n) {
            List<String> board = new ArrayList<>();
            for(char[] r : placed) {
                board.add(new String(r));
            }
            res.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<n;col++) {
            if(isSafe(n,row,col)) {
                placed[row][col] = 'Q';
                cols[col] = true;
                posDiag[row+col] = true;
                negDiag[row-col+n] = true;

                backtrack(n,row+1);
                placed[row][col] = '.';
                cols[col] = false;
                posDiag[row+col] = false;
                negDiag[row-col+n] = false;
            }
        }
        
    }
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        placed = new char[n][n];
        cols = new boolean[n];
        posDiag = new boolean[2*n];
        negDiag = new boolean[2*n];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                placed[i][j] = '.';
            }
        }
        backtrack(n,0);
        return res;
        
    }
}

class Solution {
    List<List<String>> res;
    List<String> placed;
    boolean[] cols,posDiag,negDiag;
    public boolean isSafe(int n,int row , int col) {
        if(cols[col] || posDiag[row+col] || negDiag[row-col+n]) {
            return false;
        }
        return true;
    }
    public void backtrack(int n,int row) {
        if(row == n) {
            res.add(new ArrayList<>(placed));
            return;
        }
        for(int col=0;col<n;col++) {
            if(isSafe(n,row,col)) {
                StringBuilder sb = new StringBuilder(placed.get(row));
                sb.setCharAt(col,'Q');
                cols[col] = true;
                posDiag[row+col] = true;
                negDiag[row-col+n] = true;
                placed.set(row,sb.toString());
                backtrack(n,row+1);
                sb.setCharAt(col,'.');
                placed.set(row,sb.toString());
                cols[col] = false;
                posDiag[row+col] = false;
                negDiag[row-col+n] = false;
            }
        }
        
    }
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        placed = new ArrayList<>();
        cols = new boolean[n];
        posDiag = new boolean[2*n];
        negDiag = new boolean[2*n];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append('.');
        }
        String s = sb.toString();
        for(int i=0;i<n;i++) {
            placed.add(s);
        }
        backtrack(n,0);
        return res;
        
    }
}

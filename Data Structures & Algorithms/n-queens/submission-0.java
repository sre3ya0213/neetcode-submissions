class Solution {

    List<List<String>> res;
    List<String> board;
    public boolean isSafe( List<String> placed, int row , int col) {
        for(int i=0;i<row;i++) {
            for(int j=0;j<placed.get(i).length();j++) {
                if(placed.get(i).charAt(j) == '.') {
                    continue;
                }
                if(j == col) {
                    return false;
                }
                if(Math.abs(i-row) == Math.abs(j-col)) {
                    return false;
                }
            }
            
        }
        return true;   
    }
    public void backtrack(int n,int row) {
        if(row == n) {
            res.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<n;col++) {
            if(isSafe(board,row,col)) {
                StringBuilder cur = new StringBuilder(board.get(row));
                cur.setCharAt(col,'Q');
                board.set(row,cur.toString());
                backtrack(n,row+1);
                cur.setCharAt(col,'.');
                board.set(row,cur.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
         res = new ArrayList<>();
         board = new ArrayList<>();
         StringBuilder sb = new StringBuilder();
         for(int i= 0;i<n;i++) {
            sb.append(".");
         }
         for(int i=0;i<n;i++) {
            board.add(sb.toString());
         }
         backtrack(n,0);
         return res;
    }
}

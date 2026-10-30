class Solution {
    boolean[][] used;

    public boolean backtrack(char[][] board,String word,boolean[][] used ,int row,int col,int i) {
        if(i == word.length()) {
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(i) || used[row][col]) {
            return false;
        }
        used[row][col] = true;
        i++;
        boolean res = backtrack(board,word,used,row,col-1,i) || backtrack(board,word,used,row,col+1,i) || backtrack(board,word,used,row-1,col,i) || backtrack(board,word,used,row+1,col,i);
        used[row][col] = false;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(backtrack(board,word,used,i,j,0))
                  return true;
                
            }
        }
        return false;
    }
}

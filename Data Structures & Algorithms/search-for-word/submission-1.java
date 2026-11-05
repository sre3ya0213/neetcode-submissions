class Solution {

    public boolean backtrack(char[][] board, String word,int row,int col,int i) {
        if(i == word.length()) {
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(i) ||  board[row][col] == '#') {
            return false;
        }
        board[row][col] ='#';
        boolean res = backtrack(board,word,row,col-1,i+1) || backtrack(board,word,row,col+1,i+1) || backtrack(board,word,row-1,col,i+1) || backtrack(board,word,row+1,col,i+1);
        board[row][col] = word.charAt(i);
        return res;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(backtrack(board,word,i,j,0)) {
                    return true;
                };
            }
        }
        return false;
        
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> box = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            box.add(new HashSet<>());
        }
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j] == '.') {
                    continue;
                }
                if(!rows.get(i).add(board[i][j]) || !cols.get(j).add(board[i][j]) || !box.get((i/3)*3 + (j/3)).add(board[i][j])) {
                    return false;
                }
            }
        }

        return true;
        
    }
}

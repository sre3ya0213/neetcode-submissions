class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }
    TrieNode root;
    List<String> res;
    StringBuilder sb;
    public void insert(String s) {
        TrieNode cur = root;
        for(char c : s.toCharArray()) {
            int i = c - 'a';
            if(cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.isEndOfWord = true;
    }
    public void dfs(char[][] board,int row,int col,TrieNode root) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#' || root.children[board[row][col] - 'a'] == null) {
            return;
        }
        sb.append(board[row][col]);
        if(root.children[board[row][col] - 'a'].isEndOfWord) {
            res.add(sb.toString());
            root.children[board[row][col] - 'a'].isEndOfWord = false;
        }
        int i = board[row][col]-'a';
        board[row][col] = '#';
        dfs(board,row-1,col,root.children[i]);
        dfs(board,row+1,col,root.children[i]);
        dfs(board,row,col+1,root.children[i]);
        dfs(board,row,col-1,root.children[i]);
        board[row][col] = sb.charAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        res = new ArrayList<>();
        sb = new StringBuilder();
        for(String word : words) {
            insert(word);
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(board,i,j,root);
            }
        }
        return res;
    }
}

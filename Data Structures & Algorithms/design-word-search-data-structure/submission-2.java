class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.isEndOfWord = true;
    }

    public boolean dfs(String word ,TrieNode root,int j) {
        TrieNode cur = root;
        for(int i=j;i<word.length();i++) {
            if(word.charAt(i) == '.') {
                for(TrieNode child : cur.children) {
                    if(child != null && dfs(word,child,i+1)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if(cur.children[word.charAt(i)-'a'] == null) {
                    return false;
                }
                cur = cur.children[word.charAt(i)-'a'];
            }
        }
        return cur.isEndOfWord;
    }

    public boolean search(String word) {
        return dfs(word,root,0);
    }
}

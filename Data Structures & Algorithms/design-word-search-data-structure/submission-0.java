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

    public boolean dfs(String word ,TrieNode root,int i) {
        if(i == word.length()) {
            return root.isEndOfWord;
        }
        if(word.charAt(i) == '.') {
            for(int j=0;j<26;j++) {
                if(root.children[j] != null) {
                    if(dfs(word,root.children[j],i+1)) {
                        return true;
                    }
                }
            }
            return false;
        }
        if(root.children[word.charAt(i)-'a'] == null) {
            return false;
        }
        return dfs(word,root.children[word.charAt(i)-'a'],i+1);
        
    }

    public boolean search(String word) {
        return dfs(word,root,0);
    }
}

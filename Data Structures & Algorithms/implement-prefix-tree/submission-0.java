class PrefixTree {

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }
    TrieNode root;
    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int i = c-'a';
            if(cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int i = c-'a';
            if(cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }
        return cur.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()) {
            int i = c-'a';
            if(cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }
        return true;
    }
}

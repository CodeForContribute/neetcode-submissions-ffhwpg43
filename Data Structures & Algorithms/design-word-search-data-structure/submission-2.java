class TrieNode{
    TrieNode[]children;
    boolean isEndWord;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEndWord = false;
    }
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = this.root;
        for(char ch : word.toCharArray()){
            if(cur.children[ch-'a'] == null){
                cur.children[ch-'a'] = new TrieNode();
            }
            cur = cur.children[ch-'a'];
        }
        cur.isEndWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, TrieNode node){
        TrieNode cur = node;
        for(int i = idx; i < word.length();i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(TrieNode child : cur.children){
                    if(child != null && dfs(word,i+1, child)){
                        return true;
                    }
                }
                return false;
            }else{
                if(cur.children[ch-'a'] == null){
                    return false;
                }
                cur = cur.children[ch-'a'];
            }
        }
        return cur.isEndWord;
    }
}

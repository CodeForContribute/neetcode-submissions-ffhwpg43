class TrieNode{
    TrieNode[]children;
    int idx;
    int refs;
    
    public TrieNode(){
        this.children = new TrieNode[26];
        this.idx = -1;
        this.refs = 0;
    }
}

class Trie{
    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void addWord(String word, int index){
        TrieNode cur = this.root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(cur.children[idx] == null){
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
            cur.refs++;
        }
        cur.idx = index;
    }
}

class Solution {
    // backtracking + trie
    private List<String>result = new ArrayList();
    public List<String> findWords(char[][] grid, String[] words) {
        if(grid == null || grid.length == 0)return new ArrayList();
        int m = grid.length, n = grid[0].length;
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++){
            trie.addWord(words[i], i);
        }
        for(int r = 0 ; r < m; r++){
            for(int c = 0 ;c < n;c++){
                dfs(grid,trie.root,r,c,words);
            }
        }
        return result;
    }

    private void dfs(char[][]grid, TrieNode node, int r, int c, String[]words){
        // base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '*' || node.children[grid[r][c] -'a'] == null)return;
        char tmp = grid[r][c];
        grid[r][c] = '*';
        TrieNode prev = node;
        node = node.children[tmp-'a'];
        // found a word
        if(node.idx != -1){
            result.add(words[node.idx]);
            node.idx = -1;
            node.refs--;
            // pruning the node with refs = 0
            // if(node.refs == 0){
            //     node = null;
            //     prev.children[tmp-'a'] = null;
            //     grid[r][c] = tmp;
            //     return;
            // }
        }

        dfs(grid,node,r+1,c,words);
        dfs(grid,node,r-1,c,words);
        dfs(grid,node,r,c-1,words);
        dfs(grid,node,r,c+1,words);
        grid[r][c] = tmp;
    }
}

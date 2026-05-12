class TrieNode{
    Map<Character,TrieNode>children;
    boolean isWord;
    public TrieNode(){
        this.children = new HashMap();
        this.isWord = false;
    }
}

class Trie{
    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }
    public void addWord(String word){
        TrieNode cur = this.root;
        for(char ch : word.toCharArray()){
            cur.children.putIfAbsent(ch, new TrieNode());
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }
}


class Solution {
    private Set<String>result;
    private boolean[][]visited;

    public List<String> findWords(char[][] grid, String[] words) {
        Trie trie = new Trie();
        for(String word: words){
            trie.addWord(word);
        }
        int m = grid.length, n = grid[0].length;
        result = new HashSet();
        visited = new boolean[m][n];
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                dfs(grid,r,c,trie.root, "");
            }
        }
        return new ArrayList(result);
    }

    private void dfs(char[][]grid, int r, int c, TrieNode node, String word){
        // base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] ||  !node.children.containsKey(grid[r][c])){
            return;
        }
        visited[r][c] = true;
        node = node.children.get(grid[r][c]);
        word += grid[r][c];
        if(node.isWord)result.add(word);

        dfs(grid,r+1,c,node,word);
        dfs(grid,r-1,c,node,word);
        dfs(grid,r,c-1,node,word);
        dfs(grid,r,c+1,node,word);

        visited[r][c] = false;
    }
}

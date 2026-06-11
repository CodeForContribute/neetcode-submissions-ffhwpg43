class TrieNode{
    Map<Character,TrieNode>children;
    boolean isWord;

    public TrieNode(){
        children = new HashMap();
        isWord = false;
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isWord = true;
    }

    public boolean search(String s, int left, int right){
        TrieNode node = root;
        for(int idx = left ; idx <= right; idx++){
            if(!node.children.containsKey(s.charAt(idx))){
                return false;
            }
            node = node.children.get(s.charAt(idx));
        }
        return node.isWord;
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)return true;
        Trie trie = new Trie();
        for(String word : wordDict)trie.insert(word);
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        dp[n] = true;
        int maxLen = 0;
        for(String word: wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        for(int i = n-1; i >= 0; i--){

            for(int j = i; j < Math.min(maxLen+i,n);j++){
                if(trie.search(s,i,j)){
                    dp[i] = dp[j+1];
                    if(dp[i])break;
                }
            }
        }
        return dp[0];
    }
}

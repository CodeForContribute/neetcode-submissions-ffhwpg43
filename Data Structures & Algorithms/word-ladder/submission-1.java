class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord))return 0;
        Set<String>words = new HashSet(wordList);
        Queue<String>q = new LinkedList();
        int ans = 0;
        q.offer(beginWord);

        while(!q.isEmpty()){
            ans++;
            int size = q.size();

            for(int i = size; i > 0; i--){
                String node = q.poll();
                if(node.equals(endWord))return ans;
                for(int j = 0; j < node.length(); j++){
                    for(char c = 'a' ; c <= 'z'; c++){
                        if(c == node.charAt(j))continue;
                        String ne = node.substring(0,j) + c + node.substring(j+1);
                        if(words.contains(ne)){
                            q.offer(ne);
                            words.remove(ne);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

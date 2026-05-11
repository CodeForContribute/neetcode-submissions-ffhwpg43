class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // bfs from both sides - beginWord, endWord - meet in the middle.
        if(!wordList.contains(endWord))return 0;
        //int m = wordList.get(0).length();
        Set<String>wordSet = new HashSet(wordList);
        Queue<String>qb = new LinkedList(), qe = new LinkedList();
        Map<String, Integer>fromBegin = new HashMap();
        Map<String, Integer>fromEnd = new HashMap();
        qb.add(beginWord);qe.add(endWord);
        fromBegin.put(beginWord, 1);
        fromEnd.put(endWord,1);

        while(!qb.isEmpty() && !qe.isEmpty()){
            if(qb.size() > qe.size()){
                Queue<String>tempQ = qb;
                qb = qe;
                qe = tempQ;
                Map<String,Integer>tmpMa = fromBegin;
                fromBegin = fromEnd;
                fromEnd = tmpMa;
            }
            int size = qb.size();
            for(int k = 0; k < size; k++){
                String word = qb.poll();
                int steps = fromBegin.get(word);
                for(int i = 0; i < word.length(); i++){
                    for(char ch = 'a'; ch <= 'z';ch++){
                        if(ch == word.charAt(i))continue;
                        String ne = word.substring(0,i) + ch + word.substring(i+1);
                        if(!wordSet.contains(ne))continue;
                        if(fromEnd.containsKey(ne))return steps + fromEnd.get(ne);
                        if(!fromBegin.containsKey(ne)){
                            fromBegin.put(ne , steps+1);
                            qb.add(ne);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

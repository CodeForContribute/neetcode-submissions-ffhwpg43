class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))return 0;
        if(wordList == null || !wordList.contains(endWord))return 0;
        Set<String>wordSet = new HashSet(wordList);
        Queue<String>qb = new LinkedList(), qe = new LinkedList();
        qb.add(beginWord);qe.add(endWord);
        Map<String,Integer>fromBegin = new HashMap(), fromEnd = new HashMap();
        fromBegin.put(beginWord,1);fromEnd.put(endWord,1);
        while(!qb.isEmpty() && !qe.isEmpty()){
            if(qb.size() > qe.size()){
                swap(qb,qe);
                swap(fromBegin, fromEnd);
            }
            int size = qb.size();
            for(int i = 0; i < size; i++){
                String word = qb.poll();
                int steps = fromBegin.get(word);
                for(int j = 0; j < word.length(); j++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        String ne = word.substring(0,j) + ch + word.substring(j+1);
                        if(!wordSet.contains(ne))continue;
                        if(fromEnd.containsKey(ne))return steps + fromEnd.get(ne);
                        if(!fromBegin.containsKey(ne)){
                            fromBegin.put(ne, steps+1);
                            qb.add(ne);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public <T> void swap(T o1, T o2){
        T tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
}

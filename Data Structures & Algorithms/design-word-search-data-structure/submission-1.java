class WordDictionary {
    private List<String>store;

    public WordDictionary() {
        this.store = new ArrayList();
    }

    public void addWord(String word) {
        store.add(word);
    }

    public boolean search(String word) {
        for(String w : store){
            if(w.length() != word.length())continue;
            int idx = 0, m = w.length();
            while(idx < m){
                if(w.charAt(idx) == word.charAt(idx) || word.charAt(idx) == '.'){
                    idx++;
                }else{
                    break;
                }
            }
            if(idx == w.length())return true;
        }
        return false;
    }
}

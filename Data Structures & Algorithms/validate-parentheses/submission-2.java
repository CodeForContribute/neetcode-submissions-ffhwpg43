class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)return true;
        int n = s.length();
        Map<Character,Character>mp = new HashMap();
        mp.put(')','(');mp.put(']','[');mp.put('}','{');
        Stack<Character>stack = new Stack();
        for(char ch : s.toCharArray()){
            if(mp.containsKey(ch)){
                Character top = stack.isEmpty() ? '@':stack.pop();
                if(top != mp.get(ch))return false;
            } else stack.push(ch);
        }
        return stack.isEmpty();
    }
}

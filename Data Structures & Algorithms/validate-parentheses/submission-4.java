class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)return true;
        int n = s.length();
        Map<Character, Character>mp = new HashMap();
        mp.put(')', '(');mp.put(']', '[');mp.put('}','{');
        Stack<Character>stack = new Stack();
        for(char ch : s.toCharArray()){
            if(mp.containsKey(ch)){
                char top = stack.isEmpty() ? '#' : stack.pop();
                if(mp.get(ch) != top)return false;
            }else stack.push(ch);
        }
        return stack.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)return true;
        int n = s.length();
        Map<Character,Character>mp = new HashMap();
        mp.put(')','(');mp.put(']','[');mp.put('}','{');
        Stack<Character>stack = new Stack();
        for(char ch : s.toCharArray()){
            if(mp.containsKey(ch)){
                // if(stack.isEmpty())return false;
                Character top = stack.isEmpty() ? '@':stack.pop();
                System.out.println("top >> " + top + "ch >> " + mp.get(ch));
                if(top != mp.get(ch))return false;
            } else stack.push(ch);
        }
        return stack.isEmpty();
    }
}

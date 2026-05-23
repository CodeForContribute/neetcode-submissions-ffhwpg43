class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)return true;
        int n = s.length();
        int left = 0, right = n-1;
        while(left <= right){
            // if non-alpha , ignore it.
            while(left < right && !alphanum(s.charAt(left)))left++;
            while(left < right && !alphanum(s.charAt(right)))right--;
            if(Character.toLowerCase(s.charAt(left++)) != 
            Character.toLowerCase(s.charAt(right--)))return false;
        }
        return true;
    }
    public boolean alphanum(char ch){
        return ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'));
       
    }
}

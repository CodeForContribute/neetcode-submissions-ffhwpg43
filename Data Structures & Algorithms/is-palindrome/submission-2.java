class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)return true;
        int left = 0, right = s.length()-1;
        while(left <= right){
            // if non alpha numeric - ignore and continue
            while(left < right && !alphanum(s.charAt(left)))left++;
            while(right > left && !alphanum(s.charAt(right)))right--;
            if(Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--)))return false;
        }
        return true;
        // if(s == null || s.length() == 0)return true;
        // int left = 0, right = s.length()-1;
        // while(left <= right){
        //     // if non alpha numeric - ignore and continue
        //     while(left < right && !alphaNum(s.charAt(left)))left++;
        //     while(right > left && !alphaNum(s.charAt(right)))right--;
        //     if(Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))){
        //         return false;
        //     }
        // }
        // return true;
    }
    public boolean alphanum(char ch){
        return (ch >='A' && ch <= 'Z' || 
        ch >= 'a' && ch <= 'z' || 
        ch >= '0' && ch <= '9');
    }
}

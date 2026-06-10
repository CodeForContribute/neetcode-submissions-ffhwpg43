class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int resultLen = 0, n = s.length();
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int left = i, right = j;
                while(left < right && s.charAt(left) == s.charAt(right)){
                    left++;
                    right--;
                }
                if(left >= right && resultLen < ( j - i + 1)){
                    result = s.substring(i,j+1);
                    resultLen = j - i +1;
                }
            }
        }
        return result;
    }
}

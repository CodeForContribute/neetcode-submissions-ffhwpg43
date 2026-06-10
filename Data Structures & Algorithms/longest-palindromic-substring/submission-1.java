class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0, reslen = 0;
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n;j++){
                if(s.charAt(i) == s.charAt(j) && ((j-i <= 2) || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(reslen < ( j - i + 1)){
                        reslen = j-i+1;
                        resIdx = i;
                    }
                }
            }
        }
        return s.substring(resIdx, resIdx + reslen);
        // String result = "";
        // int resultLen = 0, n = s.length();
        // for(int i = 0; i < n; i++){
        //     for(int j = i; j < n; j++){
        //         int left = i, right = j;

        //         while(left < right && s.charAt(left) == s.charAt(right)){
        //             left++;
        //             right--;
        //         }
        //         if(left >= right && resultLen < ( j - i + 1)){
        //             result = s.substring(i,j+1);
        //             resultLen = j - i +1;
        //         }
        //     }
        // }
        // return result;
    }
}

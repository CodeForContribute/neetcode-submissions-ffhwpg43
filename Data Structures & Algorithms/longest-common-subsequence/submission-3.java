class Solution {
    public int longestCommonSubsequence(String a, String b) {
        if(a.length() < b.length()){
            swap(a,b);
        }
        int m = a.length(), n = b.length();
        int[]prev = new int[b.length()+1];
        int[]cur = new int[b.length()+1];

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(a.charAt(i) == b.charAt(j)){
                    cur[j] = 1 + prev[j+1];
                }else{
                    cur[j] = Math.max(cur[j+1],prev[j]);
                }
            }
            prev = cur;
            cur = new int[b.length()+1];
        }
        return prev[0];
    }

    private <T> void swap(T a, T b){
        T tmp = a;
        a = b;
        b = tmp;
    }
}

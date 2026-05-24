class Solution {
    private int bitCnt(int n){
        int ans = 0;
        while(n != 0){
            ans++;
            n &= (n-1);
        }
        return ans;
    }
    public int[] countBits(int n) {
        int[]result = new int[n+1];
        for(int a = 0; a <= n;a++){
            result[a] = bitCnt(a);
        }
        return result;
    }
}

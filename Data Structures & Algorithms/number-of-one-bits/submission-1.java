class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0){
            result += ( n & 1) == 1 ? 1 : 0;
            n >>= 1;
        }
        return result;
        // int ans = 0;
        // for(int i = 0; i < 32; i++){
        //     int bitmask = (1 << i);
        //     if((bitmask & n) != 0){
        //         ans++;
        //     }
        // }
        // return ans;
    }
}

class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int bitmask = (1 << i);
            if((bitmask & n) != 0){
                ans++;
            }
        }
        return ans;
    }
}

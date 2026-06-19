class Solution {
    public int jump(int[] arr) {
        int ans = 0, left = 0, right = 0;
        while(right < arr.length-1){
            int farthest = 0;
            for(int idx = left ; idx <= right; idx++){
                farthest = Math.max(farthest, idx + arr[idx]);
            }
            left = right + 1;
            right = farthest;
            ans++;
        }
        return ans;
    }
}

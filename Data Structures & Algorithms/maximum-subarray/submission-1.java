class Solution {
    private Integer[][]memo;
    public int maxSubArray(int[] arr) {
        memo = new Integer[arr.length][2];
        return dfs(arr, 0, false);
    }

    private int dfs(int[]arr, int idx, boolean flag){
        // base case
        if(idx == arr.length-1){
            return flag ? Math.max(0,arr[idx]) : arr[idx];
        }
        int f = flag ? 1 : 0;
        if(memo[idx][f] != null)return memo[idx][f];
        if(flag)return Math.max(0, arr[idx]+dfs(arr,idx+1,true));
        memo[idx][f] = Math.max(dfs(arr,idx+1,false), arr[idx] + dfs(arr,idx+1,true));
        return memo[idx][f];
    }
}

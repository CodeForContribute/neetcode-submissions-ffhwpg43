class Solution {
    private Boolean[]memo;
    public boolean canJump(int[] arr) {
        if(arr == null || arr.length == 0)return true;
        // dfs(idx) -> can we reach last index starting from index idx.
        // if we reach the last index - ans - true.
        int n = arr.length;
        memo = new Boolean[n];
        return dfs(arr,0);
    }

    private boolean dfs(int[]arr, int idx){
        if(memo[idx] != null)return memo[idx];
        if(idx == arr.length-1)return true;
        int end = Math.min(arr.length-1, idx+arr[idx]);
        for(int j = idx+1; j <= end; j++){
            if(dfs(arr,j)){
                memo[j] = true;
                return true;
            }
        }
        memo[idx] = false;
        return false;
    }
}

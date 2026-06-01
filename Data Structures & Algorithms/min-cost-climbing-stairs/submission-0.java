class Solution {
    private int[]dp;
    public int minCostClimbingStairs(int[] cost) {
        // define a recursive function - dfs(i) - min cost to reach the top starting from step i;
        // if i is beyond the last step -> cost is 0 - u reached the top.
        // otherwise pay the cost[i]
        // choose the min of
        //  jump 1 step -> dfs(i+1);
        //  jump 2 steps -> dfs(i+2);
        // since u can start from step 0 or step 1
        // return min(dfs(0), dfs(1));
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(dfs(cost,0) , dfs(cost,1));
    }
    private int dfs(int[]cost, int i){
        if(i >= cost.length){
            return 0;
        }
        if(dp[i] != -1)return dp[i];
        return dp[i] = cost[i] + Math.min(dfs(cost, i+1), dfs(cost,i+2));
    }
}

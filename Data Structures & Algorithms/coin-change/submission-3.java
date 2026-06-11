class Solution {
    private int[]dp;
    // private Map<Integer,Integer>dp = new HashMap();
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length ==0)return 0;
        dp = new int[amount+1];
        if(amount == 0)return 0;
        int ans = dfs(coins,amount);
        return ans == (int) 1e9 ? -1 : ans;
    }
    private int dfs(int[]coins,int amount){
        // base case
        if(amount == 0)return 0;
        if(dp[amount] != 0)return dp[amount];
        // if(dp.containsKey(amount))return dp.get(amount);
        int ans = (int) 1e9;
        for(int idx = 0; idx < coins.length; idx++){
            int coin = coins[idx];
            if(amount-coin >= 0){
                ans = Math.min(ans, 1+ dfs(coins,amount-coin));
            }
        }
        // dp.put(amount, ans);
        dp[amount] = ans;
        return ans;
    }
}

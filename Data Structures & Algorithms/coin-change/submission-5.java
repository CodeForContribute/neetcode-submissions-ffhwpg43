class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        Queue<Integer>q = new LinkedList();
        q.offer(0);
        boolean[]seen = new boolean[amount+1];
        seen[0] = true;
        int ans = 0;
        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            for(int i = 0; i < size;i++){
                int cur = q.poll();

                for(int coin : coins){
                    int nxt = cur + coin;
                    if(nxt == amount)return ans;
                    if(nxt > amount || seen[nxt])continue;
                    seen[nxt] = true;
                    q.offer(nxt);
                }
            }
        }
        return -1;
        // bottom up
        // if(amount == 0)return 0;
        // int[]dp = new int[amount+1];
        // Arrays.fill(dp, amount+1);
        // dp[0] = 0;
        // for(int i = 1 ; i <= amount; i++){
        //     for(int j = 0; j < coins.length; j++){
        //         if(coins[j] <= i){
        //             dp[i] = Math.min(dp[i],1+ dp[i-coins[j]]);
        //         }
        //     }
        // }
        // return dp[amount] > amount ? -1: dp[amount];
    }
}

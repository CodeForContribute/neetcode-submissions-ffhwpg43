class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        Map<Integer,Integer>[]dp = new HashMap[n+1];
        for(int i = 0; i <= n; i++){
            dp[i] = new HashMap();
        }
        dp[0].put(0,1);

        for(int i = 0; i < n;i++){
            for(Map.Entry<Integer,Integer>entry : dp[i].entrySet()){
                int total = entry.getKey(),count = entry.getValue();
                dp[i+1].put(total + arr[i], dp[i+1].getOrDefault(total+arr[i],0)+count);
                dp[i+1].put(total - arr[i], dp[i+1].getOrDefault(total-arr[i],0)+count);
            }
        }

        return dp[n].getOrDefault(target,0);
    }
}

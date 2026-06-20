class Solution {
    private Map<String,Integer>dp = new HashMap();
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int idx, boolean buy, int[]arr){
        if(idx >= arr.length)return 0;
        String key = idx + "-" + buy;

        if(dp.containsKey(key))return dp.get(key);
        int coolDown = dfs(idx+1, buy, arr);
        if(buy){
            int buyProfit = dfs(idx+1,false,arr)-arr[idx];
            dp.put(key, Math.max(coolDown,buyProfit));
        }else{
            int sellProfit  = dfs(idx+2, true, arr) + arr[idx];
            dp.put(key, Math.max(coolDown,sellProfit));
        }
        return dp.get(key);
    }
}

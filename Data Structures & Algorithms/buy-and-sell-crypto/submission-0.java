class Solution {
    public int maxProfit(int[] prices) {
        // brute force
        if(prices == null || prices.length == 0)return 0;
        int maxProfit = 0;
        int n = prices.length;
        for(int i = 0 ;i < n;i++){
            for(int j = i + 1; j < n;j++){
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }
}

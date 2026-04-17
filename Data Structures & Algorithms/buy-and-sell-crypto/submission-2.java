class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)return 0;
        int n = prices.length;
        int left = 0, right = 1;
        int maxProfit = 0;
        while(right < n){
            if(prices[left] < prices[right]){
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            }else{
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}

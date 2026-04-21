class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)return new int[]{};
        int n = temperatures.length;
        // we compare the current day with every future day until we either find a warmer one or reach the end.
        // if we find a warmer day, we record how many days it took. if not the ans is 0.
        int[]result = new int[n];
        for(int i = 0; i < n; i++){
            int cnt = 1;
            int j = i + 1;
            while( j < n){
                if(temperatures[j] > temperatures[i]){
                    break;
                }
                j++;
                cnt++;
            }
            cnt = (j == n) ? 0 : cnt;
            result[i] = cnt;
        }
        return result;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)return new int[]{};
        int n = temperatures.length;
        int[]result = new int[n];
        for(int i = 0; i < n;i++){
            int cnt = 1;
            int j = i + 1;
            while(j < n){
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

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)return new int[]{};
        int n = temperatures.length;
        int[]result = new int[n];
        for(int i = n-2; i >= 0; i--){
            int j = i+1;
            while(j < n && temperatures[j] <= temperatures[i]){
                if(result[j] == 0)// no warmer day for temp lower than i ahead.no temp will be for current temp
                {
                    j = n;
                    break;
                }
                j += result[j];// move j by number of days when  we got something hotter  days for j
            }
            if(j < n){
                result[i] = j - i;
            }
        }
        return result;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temps) {
        if(temps == null || temps.length == 0)return new int[]{};
        int n = temps.length;
        int[]result = new int[n];
        for(int i = n-2; i >= 0; i--){
            int j = i + 1;
            while( j < n && temps[j] <= temps[i]){
                if(result[j] == 0){
                    j = n ;
                    break;
                }
                j += result[j];
            }
            if( j < n){
                result[i] = j - i;
            }
        }
        return result;

        // Stack<Integer>stack = new Stack();
        // for(int i = 0; i < n;i++){
        //     int tmp = temps[i];
        //     while(!stack.isEmpty() && tmp > temps[stack.peek()]){
        //         int days = i - stack.peek();
        //         result[stack.peek()] = days;
        //         stack.pop();
        //     }
        //     stack.push(i);
        // }
        // return result;
    }
}

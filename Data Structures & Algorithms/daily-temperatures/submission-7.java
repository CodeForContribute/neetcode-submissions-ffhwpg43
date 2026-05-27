class Solution {
    public int[] dailyTemperatures(int[] temps) {
        if(temps == null || temps.length == 0)return new int[]{};
        int n = temps.length;
        int[]result = new int[n];
        Stack<Integer>stack = new Stack();
        for(int i = 0; i < n;i++){
            while(!stack.isEmpty() && temps[stack.peek()] < temps[i]){
                int days = i - stack.peek();
                result[stack.peek()] = days;
                stack.pop();
            }
            stack.push(i);
        }
        return result;
        // if(temps == null || temps.length == 0)return new int[]{};
        // int n = temps.length;
        // int[]result = new int[n];
        // for(int i = n-2; i >= 0; i--){
        //     int j = i + 1;
        //     while( j < n && temps[j] <= temps[i]){
        //         // tmp[i] > tmp[j]
        //         // if we did not find a warmer day for j whose tmp < currenttmp
        //         // then there will be no warmer day for cur tmp 
        //         if(result[j] == 0){
        //             j = n ;
        //             break;
        //         }
        //         // if we found a warmer day for j, then just skip the steps - result[j]
        //         // to find the day warmer than current tmp.
        //         j += result[j];
        //     }
        //     // if j is within bounds - valid ans, update the result for cur tmp at i.
        //     if( j < n){
        //         result[i] = j - i;
        //     }
        // }
        // return result;

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

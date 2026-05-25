class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // ( 4,2), (1,2), (0,1), (7,1)
        // sort ->  (7,1),(4,2),(1,2),(0,1)
        // time -> 3, 3, 4.5,10
        if(position == null || position.length == 0 || speed == null || speed.length == 0)return 0;
        int n = position.length;
        int[][]pair = new int[n][2];
        for(int i = 0; i < n; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b)->b[0]-a[0]);// decreasing order of their distance from the target
        int fleets = 1;
        double prevTime = (double)(target - pair[0][0])/pair[0][1];
        for(int i = 1; i < n; i++){
            double curTime = (double)(target - pair[i][0])/pair[i][1];
            if(curTime > prevTime){
                fleets++;
                prevTime = curTime;
            }
        }
        return fleets;
        // if(position == null || position.length == 0 || speed == null
        //  || speed.length == 0)return 0;
        // int n = position.length;
        // int[][]pair = new int[n][2];
        // for(int i = 0; i < n;i++){
        //     pair[i][0] = position[i];
        //     pair[i][1] = speed[i];
        // }
        // Arrays.sort(pair, (a,b)->b[0]-a[0]);
        // int fleets = 1;
        // double prevTime = (double)(target - pair[0][0]) / pair[0][1];
        // for(int i = 1; i < n; i++){
        //     double curTime = (double)(target - pair[i][0]) / pair[i][1];
        //     if(curTime > prevTime){
        //         fleets++;
        //         prevTime = curTime;
        //     }
        // }
        // return fleets;
    }
}

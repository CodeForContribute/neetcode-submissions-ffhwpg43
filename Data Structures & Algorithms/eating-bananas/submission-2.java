class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null || piles.length == 0)return 0;
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        int result = right;
        while(left <= right){
            int k = left + ( right - left)/2;
            long totalTime = 0;
            for(int p : piles){
                totalTime += Math.ceil((double)p/k);
            }
            if(totalTime <= h){
                result = k;
                right = k-1;
            }else left = k + 1;
        }
        return result;
        // if(piles == null || piles.length == 0)return 0;
        // int left = 1, right = Arrays.stream(piles).max().getAsInt();
        // int result = right;
        // while(left <= right){
        //     int k = left + (right-left)/2; // assume this is the min k(eating rate)
            
        //     long totalTime = 0;
        //     for(int p : piles){
        //         totalTime += Math.ceil((double)p/k);
        //     }

        //     if(totalTime <= h){
        //         result = k;
        //         right = k - 1;  // check if there is another min k exists
        //     }else left = k + 1;
        // }
        // return result;
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // find the right place for newInterval to be placed.
        // then add the newInterval to the right place.
        // keep merging the interval when they overlap with this newInterval and subsequent mergable intervals.
        if(intervals.length == 0)return new int[][]{newInterval};
        int n = intervals.length;
        int target = newInterval[0];
        int position = bs(intervals, target);
        List<int[]>result = new ArrayList();
        for(int i = 0; i < position; i++){
            result.add(intervals[i]);
        }
        result.add(newInterval);
        for(int i = position; i < n;i++){
            result.add(intervals[i]);
        }
        List<int[]>merged = new ArrayList();
        for(int[]interval: result){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
                merged.add(interval);
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
        // if(intervals.length == 0)return new int[][]{newInterval};
        // int n = intervals.length;
        // int target = newInterval[0];
        // int left = 0, right = n-1;
        // while(left <= right){
        //     int mid = left + (right - left)/2;
        //     if(intervals[mid][0] < target){
        //         left = mid+1;
        //     }else right = mid-1;
        // }
        // List<int[]>result = new ArrayList();
        // for(int i = 0; i < left;i++){
        //     result.add(intervals[i]);
        // }
        // result.add(newInterval);
        // for(int i = left ;i < n;i++){
        //     result.add(intervals[i]);
        // }
        // List<int[]>merged = new ArrayList();
        // for(int[]interval: result){
        //     if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
        //         merged.add(interval);
        //     }else{
        //         merged.get(merged.size()-1)[1] = Math.max(
        //             merged.get(merged.size()-1)[1], interval[1]
        //         );
        //     }
        // }
        // return merged.toArray(new int[0][]);
    }

    private int bs(int[][]intervals, int target){
        int left = 0, right = intervals.length-1;
        while(left <= right){
            int mid = left + ( right - left)/2;
            if(intervals[mid][0] < target){
                left = mid+1;
            }else right = mid-1;
        }
        return left;
    }
}

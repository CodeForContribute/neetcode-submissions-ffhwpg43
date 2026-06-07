class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0)return 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int result = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            // if the current interval overlap with prev ones
            // keep the interval with minEnd of the two
            // for giving more rooms to upcoming future intervals.
            if(start >= prevEnd){
                // no overlap
                prevEnd = end;
            }else{
                // overlap
                result++;
                prevEnd = Math.min(prevEnd, end);
            }
        }
        return result;
    }
}

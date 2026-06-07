class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0)return 0;
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int result = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            // no overlap
            if(start >= prevEnd){
                prevEnd = end;
            }else{
                result++;
            }
        }
        return result;
    }
}

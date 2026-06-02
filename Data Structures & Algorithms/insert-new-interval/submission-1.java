class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, idx = 0;
        List<int[]>result = new ArrayList();
        // while there is no overlap of an interval,will keep the interval in the result.
        while(idx < n && intervals[idx][1] < newInterval[0]){
            result.add(intervals[idx]);
            idx++;
        }
        while(idx < n && newInterval[1] >= intervals[idx][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        result.add(newInterval);
        while(idx < n){
            result.add(intervals[idx++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}

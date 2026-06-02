class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // greedy
        // scan from left to right and every interval will fall into 3 categories.
        // completely after newInterval - if newInterval ends before the current interval starts, there will be no overlap
        // Completely before newInterval - if the current interval ends before newInterval starts, it can be added to the result.
        // Overlapping with newInterval - we merge them by expanding newInterval to cover both ranges.
        List<int[]>result = new ArrayList();
        if(intervals.length == 0)return new int[][]{newInterval};
        for(int[]interval: intervals){
            // after newInterval scenario and before newInterval scenario
            if(newInterval == null || interval[1] < newInterval[0]){
                result.add(interval);
            // interval after newInterval.
            }else if(interval[0] > newInterval[1]){
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            // overlap scenario
            }else{
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if(newInterval != null)result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}

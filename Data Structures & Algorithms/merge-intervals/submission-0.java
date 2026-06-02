class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)return new int[][]{};
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);// sort by start time.
        List<int[]>result = new ArrayList();
        int[]current = intervals[0];
        result.add(current);
        for(int[]interval: intervals){
            if(current[1] >= interval[0]){
                current[1] = Math.max(interval[1], current[1]);
            }else{
                current = interval;
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

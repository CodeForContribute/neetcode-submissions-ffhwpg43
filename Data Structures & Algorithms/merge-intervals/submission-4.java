class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)return new int[][]{};
        int n = intervals.length;
        int max = 0;
        for(int[]interval : intervals){
            max = Math.max(max, interval[0]);
        }
        int[]mp = new int[max+1];
        for(int[] interval : intervals){
            int start = interval[0] ,end = interval[1];
            mp[start] = Math.max(mp[start], end+1);
        }
        int r = 0, have = -1, intervalStart = -1;
        for(int i = 0; i < mp.length;i++){
            if(mp[i] != 0){
                if(intervalStart == -1)intervalStart = i;
                have = Math.max(have, mp[i]-1);
            }
            if(have == i){
                intervals[r++] = new int[]{intervalStart, have};
                have = -1;
                intervalStart = -1;
            }
        }
        if(intervalStart != -1){
            intervals[r++] = new int[]{intervalStart,have};
        }
        if(intervals.length == r)return intervals;
        int[][]result = new int[r][];
        for(int i = 0; i < r;i++){
            result[i] = intervals[i];
        }
        return result;
    }
}

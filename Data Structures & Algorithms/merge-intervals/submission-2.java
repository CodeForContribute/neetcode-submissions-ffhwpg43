class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)return new int[][]{};
        int n = intervals.length;
        Map<Integer,Integer>map = new TreeMap();

        for(int[]interval: intervals){
            int start = interval[0],end = interval[1];
            map.put(start, map.getOrDefault(start,0)+1);
            map.put(end, map.getOrDefault(end,0)-1);
        }

        List<int[]>result = new ArrayList();
        int have = 0;
        int[]interval = new int[2];

        for(int point: map.keySet()){
            if(have == 0)interval[0] = point;
            
            have += map.get(point);
            if(have == 0){
                interval[1] = point;
                result.add(new int[]{interval[0], interval[1]});
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0)return 0;
        TreeMap<Integer,Integer>mp = new TreeMap();
        for(Interval interval: intervals){
            int start = interval.start;
            int end = interval.end;
            mp.put(start, mp.getOrDefault(start,0)+1);
            mp.put(end, mp.getOrDefault(end,0)-1);
        }
        int prev = 0, ans = 0;
        for(int key: mp.keySet()){
            prev += mp.get(key);
            ans = Math.max(prev,ans);
        }
        return ans;
    }
}

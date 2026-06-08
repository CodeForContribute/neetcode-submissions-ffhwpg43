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
        List<int[]>times = new ArrayList();
        for(Interval interval: intervals){
            times.add(new int[]{interval.start,1});
            times.add(new int[]{interval.end, -1});
        }
        times.sort((a,b)->a[0] == b[0] ? a[1]-b[1]: a[0]-b[0]);
        int ans = 0, cnt = 0;
        for(int[]t: times){
            cnt += t[1];
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}

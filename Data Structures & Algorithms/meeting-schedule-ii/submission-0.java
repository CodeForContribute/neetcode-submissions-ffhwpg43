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
        // each meeting needs a room from its start time to its end time.
        // if a meeting starts after or at the same time another meeting ends, they can
        // share the same room.
        // otherwise we need a new room.
        // to efficiently track room availability, we use min heap.
        // [(0,40),(5,10),(15,20)]
        // min heap -> 40
        if(intervals == null || intervals.size() == 0)return 0;
        Collections.sort(intervals, (a,b)->a.start-b.start);
        PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
        for(Interval interval: intervals){
            if(!pq.isEmpty() && pq.peek() <= interval.start){
                pq.poll();
            }
            pq.offer(interval.end);
        }
        return pq.size();
    }
}

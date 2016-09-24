/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval I1, Interval I2) {
                return I1.start - I2.start;
            }
        });
        
        PriorityQueue<Integer> endTime = new PriorityQueue<Integer>();
        int res = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            while (endTime.size() > 0 && endTime.peek() <= intervals[i].start) {
                endTime.poll();
            }
            
            endTime.offer(intervals[i].end);
            res = Math.max(res, endTime.size());
        }
        
        return res;
    }
}

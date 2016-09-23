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
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval I1, Interval I2) {
                return I1.start - I2.start;
            }
        });
        
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        
        return true;
    }
}

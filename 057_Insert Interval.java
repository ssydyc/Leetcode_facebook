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
    private void appendInterval(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
        } else {
            if (intervals.get(intervals.size() - 1).end < newInterval.start) {
                intervals.add(newInterval);
            } else {
                intervals.get(intervals.size() - 1).end = Math.max(newInterval.end, intervals.get(intervals.size() - 1).end);
            }
        }
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start >= newInterval.start) {
                appendInterval(res, newInterval);
            }
            appendInterval(res, intervals.get(i));
        }
        
        if (res.size() == 0 || res.get(res.size() - 1).start < newInterval.start) {
            appendInterval(res, newInterval);
        }
        
        return res;
    }
}

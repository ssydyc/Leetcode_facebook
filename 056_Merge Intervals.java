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
    private void addInterval(List<Interval> res, Interval interval) {
        if (res.size() == 0 || res.get(res.size() - 1).end < interval.start) {
            res.add(interval);
        } else {
            res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, interval.end);
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval I1, Interval I2) {
                return I1.start - I2.start;
            } 
        });
        
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
                addInterval(res, intervals.get(i));
        }
        
        return res; 
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        
        while (first + 1 < last) {
            int mid = first + (last -first) / 2;
            if (isBadVersion(mid)) {
                last = mid;
            } else {
                first = mid;
            }
        }
        
        if (isBadVersion(first)) {
            return first;
        } else {
            return last;
        }
    }
}

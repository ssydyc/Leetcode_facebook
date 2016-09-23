public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int first = 1;
        int last = x;
        
        while (first + 1 < last) {
            int mid = first + (last - first) / 2;
            
            if (mid * mid == x) {
                return mid;
            } else if (mid < x / mid) {
                first = mid;
            } else {
                last = mid;
            }
        }
        
        if (last <= x / last) {
            return last;
        } else {
            return first;
        }
    }
}

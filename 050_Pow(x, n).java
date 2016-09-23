public class Solution {
    public double myPow(double x, int n) {
        long N = new Long(n);
        
        boolean flip = false;
        if (N < 0) {
            flip = true;
            N = -N;
        }
        
        int sign = 1;
        if (x < 0) {
            x = -x;
            sign = N % 2 == 0 ? sign : -sign;
        }
        
        double res = 1;
        double cur = x;
        while(N > 0) {
            if(N % 2 == 1) {
                res *= cur;
            }
            cur = cur * cur;
            N = N >> 1;
        }
        
        return flip ? 1 / (sign * res) : sign * res; 
    }
}

public class Solution {
    private int oneRomanToInt(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        
        return 0;
    }
    
    public int romanToInt(String s) {
        int res = 0;
        int curMax = 0;
        for (int i = s.length() - 1; i >=0 ; i--) {
            int cur = oneRomanToInt(s.charAt(i));
            if (cur >= curMax) {
                res += cur;
                curMax = cur;
            } else {
                res -= cur;
            }
        }
        
        return res;
    }
}

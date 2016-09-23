public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        int prev = 0;
        int cur = 1;
        int next = 0;
        
        for (int i = 0; i < s.length(); i++) {
            next = 0;
                
            // case that add one letter
            if (s.charAt(i) != '0') {
                next += cur;
            } 
                
            // case that add two letters
            if (i != 0) {
                int num = Integer.valueOf(s.substring(i - 1, i + 1));
                if (num >= 10 && num <= 26 ) {
                    next += prev;
                }
            }
            
            // change values;
            prev = cur;
            cur = next;
        }
        
        return cur;
    }
}

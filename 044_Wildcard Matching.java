public class Solution {
    public boolean isMatch(String s, String p) {
        StringBuilder singleStarP = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (i == 0 || p.charAt(i) != '*' || p.charAt(i) != p.charAt(i - 1)) {
                singleStarP.append(p.charAt(i));
            }
        }
        
        String newP = singleStarP.toString();
        
        // initialize values for DP
        boolean[] cur = new boolean[newP.length() + 1];
        
        boolean[] prev = new boolean[newP.length() + 1];
        prev[0] = true;
        for (int i = 1; i < prev.length; i++) {
            if (newP.charAt(i - 1) == '*') {
                prev[i] = true;
            } else {
                break;
            }
        }
        
        // run DP
        for (int i = 0; i < s.length(); i++) {
            cur[0] = false;
                
            for (int j = 1; j < prev.length; j++) {
                if (newP.charAt(j - 1) == '*') {
                    cur[j] = (prev[j] || cur[j - 1] || prev[j - 1]);
                } else if (newP.charAt(j - 1) == '?') {
                    cur[j] = prev[j - 1];
                } else {
                    cur[j] = ((prev[j - 1]) && (s.charAt(i) == newP.charAt(j - 1)));
                }
            }
            
            boolean[] temp = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev[prev.length - 1];
    }
}

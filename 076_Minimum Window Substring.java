public class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) {
            return "";
        }
        
        int[] charRecord = new int[128];
        Arrays.fill(charRecord, Integer.MIN_VALUE);
        int numUnsatisfied = 0;
        
        // initilize
        for (int i = 0; i < t.length(); i++) {
            if (charRecord[(int)t.charAt(i)] == Integer.MIN_VALUE) {
                charRecord[(int)t.charAt(i)] = 1;
                numUnsatisfied++;
            } else {
                charRecord[(int)t.charAt(i)]++;
            }
        }
        
        // find the window size
        int begin = 0;
        int end = 0;
        int head = -1;
        int minLen = Integer.MAX_VALUE;
        
        while (end < s.length() || numUnsatisfied == 0) {
            if (numUnsatisfied == 0) {
                if (minLen > end - begin) {
                    head = begin;
                    minLen = end - begin;
                }
                
                char cur = s.charAt(begin);
                if (charRecord[(int)cur] != Integer.MIN_VALUE) {
                    charRecord[(int)cur]++;
                    if (charRecord[(int)cur] == 1) {
                        numUnsatisfied++;
                    }
                }
                begin++;
            } else {
                char cur = s.charAt(end);
                if (charRecord[(int)cur] != Integer.MIN_VALUE) {
                    charRecord[(int)cur]--;
                    if (charRecord[(int)cur] == 0) {
                        numUnsatisfied--;
                    }
                }
                end++;
            }
        }
        
        if (head == -1) {
            return "";
        } else {
            return s.substring(head, head + minLen);
        }
    }
}

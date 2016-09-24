public class Solution {
    private String CasHelper(String cur) {
        StringBuilder res = new StringBuilder();
        char curChar = cur.charAt(0);
        int num = 0;
        
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == curChar) {
                num++;
            } else {
                res.append(String.valueOf(num) + String.valueOf(curChar));
                num = 1;
                curChar = cur.charAt(i);
            }
        }
        res.append(String.valueOf(num) + String.valueOf(curChar));
        
        return res.toString();
    }
    
    public String countAndSay(int n) {
        String cur = "1";
        for (int i = 1; i < n; i++) {
            cur = CasHelper(cur);
        }
        return cur;
    }
}

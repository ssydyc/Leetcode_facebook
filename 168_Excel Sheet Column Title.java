public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        
        while(n > 0) {
            int remainder = (n - 1) % 26;
            n = (n - 1) / 26;
            res.append((char)((int)'A' + remainder));
        }
        
        return res.reverse().toString();
    }
}

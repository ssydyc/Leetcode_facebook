public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        
        int first = 0;
        int last = s.length() - 1;
        
        while (first < last) {
            if (!Character.isLetter(s.charAt(first)) && !Character.isDigit(s.charAt(first))) {
                first++;
            } else if (!Character.isLetter(s.charAt(last)) && !Character.isDigit(s.charAt(last))) {
                last--;
            } else {
                int diff = Math.abs((int)s.charAt(first) - (int)s.charAt(last));
                
                // one is digit
                if (diff != 0 && (Character.isDigit(s.charAt(first)) || Character.isDigit(s.charAt(last)))) {
                    return false;
                }
                if (diff != 0 && diff != (int)'a' - (int)'A') {
                    return false;
                }
                first++;
                last--;
            }
        }
        
        return true;
    }
}

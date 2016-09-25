public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        
        int[] res = new int[Math.max(lenA, lenB) + 1];
        
        int carry = 0;
        for(int i = 0; i < res.length; i++) {
            if (i < lenA) {
                res[res.length - i - 1] += (int) a.charAt(lenA - i - 1) - (int) '0';
            }
            
            if (i < lenB) {
                res[res.length - i - 1] += (int) b.charAt(lenB - i - 1) - (int) '0';
            }
            
            res[res.length - i - 1] += carry;
            
            if (res[res.length - i - 1] > 1) {
                res[res.length - i - 1] -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        
        StringBuilder resString = new StringBuilder();
        if (res[0] == 1) {
            resString.append('1');
        }
        
        for (int i = 1; i < res.length; i++) {
            if (res[i] == 0) {
                resString.append('0');
            } else {
                resString.append('1');
            }
        }
        
        return resString.toString();
    }
}

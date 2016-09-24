public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}

public class Solution {
    private boolean isMatchHelper(String s, String p, int indexS, int indexP, int[][] record) {
        if (indexP == p.length()) {
            return indexS == s.length();
        }
        
        // avoid duplicate check, for record, -1 means false while 1 means true, 0 means not checked;
        if (record[indexS][indexP] != 0) {
            if (record[indexS][indexP] == -1) {
                return false;
            } else {
                return true;
            }
        }
        
        // check current string
        if (indexP + 1 == p.length() || p.charAt(indexP + 1) != '*') {
            if (indexS == s.length() || (s.charAt(indexS) != p.charAt(indexP) && p.charAt(indexP) != '.')) {
                record[indexS][indexP] = -1;
            } else {
                record[indexS][indexP] = isMatchHelper(s, p, indexS + 1, indexP + 1, record) ? 1 : -1;
            }
        } else {
            // the case that we have a '*'
            int lastMatch = indexS;
            while (lastMatch < s.length() && (p.charAt(indexP) == '.' || p.charAt(indexP) == s.charAt(lastMatch))) {
                lastMatch++;
            }
            for (int i = lastMatch; i >= indexS; i--) {
                if (isMatchHelper(s, p, i, indexP + 2, record)) {
                    record[indexS][indexP] = 1;
                    break;
                } else {
                    record[indexS][indexP] = -1;
                }
            }
        }
        
        return record[indexS][indexP] == 1;
    }
    
    public boolean isMatch(String s, String p) {
        if (p.equals("")) {
            if (s.equals("")) {
                return true;
            } else {
                return false;
            }
        }
        
        int[][] record = new int[s.length() + 1][p.length()];
        return isMatchHelper(s, p, 0, 0, record);
    }
}

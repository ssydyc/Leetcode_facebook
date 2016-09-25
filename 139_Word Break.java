public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        
        int maxLen = Integer.MIN_VALUE;
        for (String word : wordDict) {
            if (word.length() > maxLen) {
                maxLen = word.length();
            }
        }
        
        for (int start = 0; start < res.length; start++) {
            if (!res[start]) {
                continue;
            }
            
            for (int j = start + 1; j < res.length && j - start <= maxLen; j++) {
                if (res[j]) {
                    continue;
                } else {
                    res[j] = wordDict.contains(s.substring(start, j));
                }
            }
        }
        
        return res[s.length()];
    }
}

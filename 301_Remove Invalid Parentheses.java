public class Solution {
    private void DFS(String s, HashSet<String> res, StringBuilder candidate, int curIndex, int leftMinusRight, int finalLength) {
        // reach to the end
        if (curIndex == s.length()) {
            if (leftMinusRight == 0 && candidate.length() == finalLength) {
                res.add(candidate.toString());
            }
            return;
        }
        
        // prune some cases
        if (candidate.length() + s.length() - curIndex < finalLength) {
            return;
        }
        
        // two cases, add or skip the character
        if (s.charAt(curIndex) == '(') {
            // add character
            candidate.append('(');
            DFS(s, res, candidate, curIndex + 1, leftMinusRight + 1, finalLength);
            candidate.deleteCharAt(candidate.length() - 1);
            
            // skip the current character
            DFS(s, res, candidate, curIndex + 1, leftMinusRight, finalLength);
                
        } else if (s.charAt(curIndex) == ')') {
            // skip ')'
            DFS(s, res, candidate, curIndex + 1, leftMinusRight, finalLength);
            
            // add ')' 
            if (leftMinusRight == 0) {
                return;
            }
            candidate.append(')');
            DFS(s, res, candidate, curIndex + 1, leftMinusRight - 1, finalLength);
            candidate.deleteCharAt(candidate.length() - 1);
        } else {
            candidate.append(s.charAt(curIndex));
            DFS(s, res, candidate, curIndex + 1, leftMinusRight, finalLength);
            candidate.deleteCharAt(candidate.length() - 1);
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        // get minimum length
        int leftMinusRight = 0;
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftMinusRight++;
                maxLength++;
            } else if (s.charAt(i) == ')') {
                if (leftMinusRight == 0) {
                    continue;
                } else {
                    leftMinusRight--;
                    maxLength++;
                }
            } else {
                maxLength++;
            } 
        }
        maxLength -= leftMinusRight;
        System.out.println(maxLength);
        
        HashSet<String> res = new HashSet<String>();
        StringBuilder candidate = new StringBuilder();
        DFS(s, res, candidate, 0, 0, maxLength);
        
        List<String> finalResult = new ArrayList<String>();
        for (String value : res) {
            finalResult.add(value);
        }
        
        return finalResult;
    }
}

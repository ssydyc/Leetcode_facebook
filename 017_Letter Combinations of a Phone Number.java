public class Solution {
    private String oneLetter(Character digit) {
        switch(digit) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
        }
        
        return "";
    }
    
    private void DFS(List<String> res, String digits, StringBuilder candidate, int startIndex) {
        if (startIndex == digits.length()) {
            res.add(candidate.toString());
            return;
        }
        
        String cur = oneLetter(digits.charAt(startIndex));
        for (int i = 0; i < cur.length(); i++) {
            candidate.append(cur.charAt(i));
            DFS(res, digits, candidate, startIndex + 1);
            candidate.deleteCharAt(candidate.length() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        
        StringBuilder candidate = new StringBuilder();
        DFS(res, digits, candidate, 0);
        
        return res;
    }
}

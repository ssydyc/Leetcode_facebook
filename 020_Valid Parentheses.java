public class Solution {
    private boolean isMatch(char parentheses1, char parentheses2) {
        if (parentheses1 == '(' && parentheses2 == ')') {
            return true;
        }
        else if (parentheses1 == '[' && parentheses2 == ']') {
            return true;
        }
        else if (parentheses1 == '{' && parentheses2 == '}') {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (cur == '(' || cur == '[' || cur == '{') {
                charStack.push(cur);
            }
            
            else {
                if (charStack.empty() || !isMatch(charStack.pop(), cur)) {
                    return false;
                }
            }
        }
        
        return charStack.empty();
    }
}

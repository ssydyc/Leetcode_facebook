public class Solution {
    private int eval(StringBuilder candidate, int target) {
        Stack<String> evalSk = new Stack<String>();
        evalSk.push("+");
        int curNum = 0;
        
        for (int i = 0; i < candidate.length(); i++) {
            if (candidate.charAt(i) == '+' || candidate.charAt(i) == '-' || candidate.charAt(i) == '*') {
                if (evalSk.peek().equals("*")) {
                    evalSk.pop();
                    curNum *= Integer.valueOf(evalSk.pop());
                }
                evalSk.push(String.valueOf(curNum));
                evalSk.push(String.valueOf(candidate.charAt(i)));
                curNum = 0;
            } else {
                if (curNum > Integer.MAX_VALUE/10) {
                    return target+1;
                }
                curNum = curNum * 10 + (int) candidate.charAt(i) - (int) '0';
            }
        }
        
        if (evalSk.peek().equals("*")) {
            evalSk.pop();
            curNum *= Integer.valueOf(evalSk.pop());
        }
        evalSk.push(String.valueOf(curNum));
        
        int res = 0;
        while (evalSk.size() != 0) {
            int temp = Integer.valueOf(evalSk.pop());
            String op = evalSk.pop();
            if (op.equals("+")) {
                res += temp;
            } else {
                res -= temp;
            }
        }
        
        return res;
    }
    
    private void addOperatorsHelper(String num, int target, int start, StringBuilder candidate, List<String> res) {
        // check values
        if (start == num.length()) {
            if (eval(candidate, target) == target) {
                res.add(candidate.toString());
            }
            return;
        }
        
        String[] possibleValues = new String[]{"", "+", "-", "*"};
        
        if (start == num.length() - 1) {
            candidate.append(num.charAt(start));
            addOperatorsHelper(num, target, start + 1, candidate, res);
            candidate.deleteCharAt(candidate.length() - 1);
            return;
        }
        
        candidate.append(num.charAt(start));
        for (int i = 0; i < possibleValues.length; i++) {
            if (num.charAt(start) == '0' && candidate.length() == 1 && possibleValues[i].equals("")) {
                continue;
            }
            if (num.charAt(start) == '0' && candidate.length() > 1 && !Character.isDigit(candidate.charAt(candidate.length() - 2)) && possibleValues[i].equals("")) {
                continue;
            }
            
            if (!possibleValues[i].equals("")) {
                candidate.append(possibleValues[i]);
            }
            
            addOperatorsHelper(num, target, start + 1, candidate, res);
            
            if (!possibleValues[i].equals("")) {
                candidate.deleteCharAt(candidate.length() - 1);
            }
        }
        candidate.deleteCharAt(candidate.length() - 1);
    }
    
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if (num == null || num.length() == 0 || target == Integer.MIN_VALUE) {
            return res;
        }
        
        addOperatorsHelper(num, target, 0, new StringBuilder(), res);
        return res;
    }
}

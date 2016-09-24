public class Solution {
    private void addDigits(int[] res, char num1Char, char num2Char, int index) {
        int addNum = ((int)num1Char - (int)'0') * ((int)num2Char - (int)'0');
        res[index] += addNum % 10;
        res[index - 1] += addNum / 10;
    }
    
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        
        // update res for the int array
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                addDigits(res, num1.charAt(i), num2.charAt(j), i + j + 1);
            }
        }
        
        // handle the carry
        int carry = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] += carry;
            carry = res[i] / 10;
            res[i] = res[i] % 10;
        }
        
        // get the final result
        StringBuilder stringResult = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && stringResult.length() == 0) {
                continue;
            }
            stringResult.append(String.valueOf(res[i]));
        }
        
        if (stringResult.length() == 0) {
            return "0";
        } else {
            return stringResult.toString();
        }
    }
}

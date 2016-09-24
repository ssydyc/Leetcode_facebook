public class Solution {
    private String englishHelper(int num) {
        if (num == 0) {
            return "";
        }
        String res = "";
        
        String[] lessThanTwenty = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        // add hundreds
        int hundreds = num / 100;
        if (hundreds != 0) {
            res += lessThanTwenty[hundreds - 1] + " Hundred";
        }
        
        // add less than hundred
        
        String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        int lessThanHundred = num % 100;
        
        if (lessThanHundred == 0) {
        } else if (lessThanHundred < 20) {
            res += " " + lessThanTwenty[lessThanHundred - 1];
        } else {
            int temp = lessThanHundred / 10;
            if (temp != 0) {
                res += " " + tens[temp - 1];
            }
            int ones = lessThanHundred % 10;
            if (ones != 0) {
                res += " " + lessThanTwenty[ones - 1];
            }
        }
        
        return res;
    }
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        int ones = num % 1000;
        num /= 1000;
        
        int thousands = num % 1000;
        num /= 1000;
        
        int millions = num % 1000;
        num /= 1000;
        
        int billions = num % 1000;
        
        String res = "";
        
        if (billions > 0) {
            res += englishHelper(billions) + " Billion";
        }
        
        if (millions > 0) {
            res += " " + englishHelper(millions) + " Million"; 
        }
        
        if (thousands > 0) {
            res += " " + englishHelper(thousands) + " Thousand";
        }
        
        if (ones > 0) {
            res += " " + englishHelper(ones);
        }
        
        String filterRes = "";
        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i) == ' ' && res.charAt(i - 1) == res.charAt(i)) {
                continue;
            }
            filterRes += res.charAt(i);
        }
        return filterRes;
    }
}

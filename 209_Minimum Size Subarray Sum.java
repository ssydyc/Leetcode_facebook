
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int curSum = 0;
        int begin = 0;
        int end = 0;
        int minLen = 0;
        
        while (end <= nums.length) {
            if (curSum < s) {
                if (end == nums.length) {
                    break;
                }
                curSum += nums[end++];
            } else {
                int curLen = end - begin;
                minLen = minLen == 0 ? curLen : Math.min(minLen, curLen);
                curSum -= nums[begin++];
            }
        }
        
        return minLen;
    }
}

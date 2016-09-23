public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> sumIndex = new HashMap<Integer, Integer>();
        sumIndex.put(0, -1);
        int curSum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (!sumIndex.containsKey(curSum)) {
                sumIndex.put(curSum, i);
            }
            if (sumIndex.containsKey(curSum - k)) {
                maxLen = Math.max(maxLen, i - sumIndex.get(curSum - k));
            }
        }
        
        return maxLen;
    }
}

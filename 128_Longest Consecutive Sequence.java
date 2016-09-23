public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        HashSet<Integer> visited = new HashSet<Integer>();
        
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (visited.contains(cur)) {
                continue;
            }
            
            int left = cur - 1;
            while (numSet.contains(left)) {
                left--;
                visited.add(left);
            }
            
            int right = cur + 1;
            while (numSet.contains(right)) {
                right++;
                visited.add(right);
            }
            
            maxLen = Math.max(maxLen, right - left - 1);
        }
        
        return maxLen;
    }
}

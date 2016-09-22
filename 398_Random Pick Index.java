public class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int index = -1;
        double maxResult = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                double cur = Math.random();
                if (cur >= maxResult) {
                    maxResult = cur;
                    index = i;
                }
            }
        }
        
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

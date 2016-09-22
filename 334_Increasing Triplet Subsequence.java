public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        
        int cur = 0;
        int[] res = new int[3];
        
        for (int i = 0; i < nums.length; i++) {
            if (cur == 0) {
                res[cur++] = nums[i];
            } else if (cur == 1) {
                if (nums[i] > res[0]) {
                    res[cur++] = nums[i];
                } else {
                    res[0] = nums[i];
                }
            } else {
                if (nums[i] > res[1]) {
                    return true;
                } else if (nums[i] > res[0] && nums[i] <= res[1]) {
                    res[1] = nums[i];
                } else {
                    res[0] = nums[i];
                }
            }
        }
        
        return false;
        
    }
}

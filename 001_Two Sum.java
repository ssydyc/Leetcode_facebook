public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] original = Arrays.copyOf(nums, nums.length);
        
        Arrays.sort(nums);
        int first = 0;
        int last = nums.length - 1;
        
        while (first < last) {
            if (nums[first] + nums[last] == target) {
                break;
            } else if (nums[first] + nums[last] > target) {
                last--;
            } else {
                first++;
            }
        }
        
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if(res[0] == -1 && original[i] == nums[first]) {
                res[0] = i;
            } else if (original[i] == nums[last]) {
                res[1] = i;
            }
        }
        
        return res;
    }
}

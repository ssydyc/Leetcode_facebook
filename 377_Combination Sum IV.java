public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        int[] numsSum = new int[target + 1];
        numsSum[0] = 1;
        
        for(int i = 0; i <= target; i++) {
            for(int j = 0; j < nums.length && nums[j] <= i; j++) {
                numsSum[i] += numsSum[i - nums[j]];
            }
        }
        
        return numsSum[target];
    }
}

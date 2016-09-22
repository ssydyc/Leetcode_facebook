public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int end = 1;
        for(int i = 1; i < nums.length; i++) {
            // if not a duplicate, remove to front and swap with end
            if(nums[i] != nums[end-1])
                nums[end++] = nums[i];
        }
        return end;
    }
}

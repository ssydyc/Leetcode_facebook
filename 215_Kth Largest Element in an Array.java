public class Solution {
    private int findKthHelper(int[] nums, int k, int begin, int end) {
        if (end - begin == 1) {
            return nums[begin]; 
        }
        
        int pivot = nums[end - 1];
        int split = begin;
        
        // conquer step
        for (int i = begin; i < end; i++) {
            if (nums[i] < pivot) {
                int temp = nums[split];
                nums[split] = nums[i];
                nums[i] = temp;
                split++;
            }
        }
        
        // divide step
        if (end - split == k) {
            return pivot;
        }
        else if (end - split < k) {
            return findKthHelper(nums, k - (end - split), begin, split);
        }
        else {
            return findKthHelper(nums, k, split, end - 1);
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        return findKthHelper(nums, k, 0, nums.length);
    }
}

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        
        int first = 0;
        int last = nums.length - 1;
        
        while (first + 1 < last) {
            int mid = first + (last - first) / 2;
            
            // compare A[mid] and nums[n - 1] to decide which half A[mid] is in 
            if (nums[mid] <= nums[last]) {
                if (target <= nums[last] && target >= nums[mid]) {
                    first = mid;
                } else {
                    last = mid;
                }
            } else {
                if (target <= nums[mid] && target >= nums[first]) {
                    last = mid;
                } else {
                    first = mid;
                }
            }
        }
        
        if (nums[first] == target) {
            return first;
        }
        
        if (nums[last] == target) {
            return last;
        }
        
        return -1;
    }
}

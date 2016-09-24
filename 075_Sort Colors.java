public class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i =0; i < nums.length; i++) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i >= count[0] && i < count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
        
        return;
    }
}

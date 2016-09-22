public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int dupFreq = 0;
        int end = 1;
        for(int i = 1; i < nums.length; i++) {
            // no duplicate
            if(nums[i] != nums[end-1]){
                nums[end++] = nums[i];
                dupFreq = 0;
            }
            else{
                // first duplicate, ok, swap current element to end!
                if(dupFreq == 0){
                    nums[end++] = nums[i];
                    dupFreq++;
                }
                // more than one duplicate
            }
        }
        return end;
    }
}

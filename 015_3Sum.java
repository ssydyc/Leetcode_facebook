public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
    
        if (nums.length < 3) {
            return res;
        }
        
        for (int first = 0; first < nums.length - 2; first++) {
            // duplicate, skip to another one
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            
            int second = first + 1;
            int third = nums.length - 1;
            
            while (second < third) {
                if (nums[first] + nums[second] + nums[third] == 0) {
                  if(((second - 1 == first) || (nums[second] != nums[second - 1])) && ((third - 1 == second) || (nums[third] != nums[third - 1]))) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    res.add(temp);
                  }
                  if (nums[third] == nums[third - 1]) {
                      third--;
                  } else {
                      second++;
                  }
                } else if (nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        
        return res;
    }
}

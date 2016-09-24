public class Solution {
    private void subsetsHelper(int[] nums, List<List<Integer>> res, List<Integer> candidate, int startIndex) {
        res.add(new ArrayList<Integer>(candidate));
        
        for (int i = startIndex; i < nums.length; i++) {
            candidate.add(nums[i]);
            subsetsHelper(nums, res, candidate, i + 1);
            candidate.remove(candidate.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        subsetsHelper(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
}

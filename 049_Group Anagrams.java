public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> keyStringMap = new HashMap<String, List<String>>();
        
        // get the hash map for each groups
        for (String curString : strs) {
            char[] keyArray = curString.toCharArray();
            Arrays.sort(keyArray);
            String hashKey = String.valueOf(keyArray);
            
            if (keyStringMap.containsKey(hashKey)) {
                keyStringMap.get(hashKey).add(curString);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(curString);
                keyStringMap.put(hashKey, temp);
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        for (String key : keyStringMap.keySet()) {
            res.add(keyStringMap.get(key));
        }
        
        return res;
    }
}

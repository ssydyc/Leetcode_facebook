public class Solution {
    public String alienOrder(String[] words) {
        if(words.length == 0){
            return "";
        }
        
        // extract orders for each pair of contigent words
        HashSet<String> pairOrders = new HashSet<String>();
        for(int i = 1; i < words.length; i++) {
            String curWord = words[i];
            String prevWord = words[i-1];
            for(int j = 0; j < curWord.length() && j < prevWord.length(); j++) {
                if(curWord.charAt(j) != prevWord.charAt(j)){
                    pairOrders.add(String.valueOf(prevWord.charAt(j)) + String.valueOf(curWord.charAt(j)));
                    break;
                }
            }
        }
        
        //count number of in degrees for each node
        HashMap<Character, Integer> inDegrees= new HashMap<Character, Integer>();
        for(String word: words) {
            for(int i = 0; i < word.length(); i++) {
                inDegrees.put(word.charAt(i), 0);
            }
        }
        
        for(String order: pairOrders) {
            Character inNode = new Character(order.charAt(1));
            if(inDegrees.containsKey(inNode)) {
                inDegrees.put(inNode, inDegrees.get(inNode) + 1);
            }
        }
        
        // topological sorting, each time eliminate a node without precedent
        StringBuilder resOrder = new StringBuilder();
        Stack<Character> candidate = new Stack<Character>();
        
        for (Character nodeKey : inDegrees.keySet()) {
            if (inDegrees.get(nodeKey) == 0) {
                candidate.push(nodeKey);
            }
        }
        
        while(candidate.size() > 0) {
            Character removeNode = candidate.pop();
            inDegrees.remove(removeNode);
            resOrder.append(removeNode);
            
            // remove the node and update corresponding inDegree
            for(String order: pairOrders) {
                if(order.charAt(0) == removeNode && inDegrees.containsKey(order.charAt(1))){
                    Character inNode = new Character(order.charAt(1));
                    inDegrees.put(inNode, inDegrees.get(inNode) - 1);
                    if (inDegrees.get(inNode) == 0) {
                        candidate.push(inNode);
                    }
                }
            }
        }
        
        if(inDegrees.keySet().size() != 0) {
            return "";
        }
        return resOrder.toString();
    }
}


// test case: ["za", "zb", "ca", "cb"]
// orderPairs: ["ab", "zc"]
// inDegrees: {"a": 0, "b": 1, "z": 0, "c": 1}

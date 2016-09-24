class TrieNode {
    // Initialize your data structure here.
    char val;
    ArrayList<TrieNode> next = new ArrayList<TrieNode>();
    
    public TrieNode() { 
        this.val = '#';
    }
    
    public TrieNode(char val) {
        this.val = val;
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            int curCharIndex = -1;
            
            // find current character
            for (int j = 0; j < cur.next.size(); j++) {
                if (cur.next.get(j).val == word.charAt(i)) {
                    curCharIndex = j;
                    break;
                }
            }
                
            if (curCharIndex == -1) {
                    TrieNode nodeToAdd = new TrieNode(word.charAt(i));
                    cur.next.add(nodeToAdd);
                    cur = nodeToAdd;
            }
            else {
                cur = cur.next.get(curCharIndex);
            }
        }
        
        TrieNode nodeToAdd = new TrieNode('$');
        cur.next.add(nodeToAdd);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    private boolean searchHelper(TrieNode root, String word, int curIndex) {
        // to the end of string
        if (curIndex == word.length()) {
            for (int i = 0; i < root.next.size(); i++) {
                if (root.next.get(i).val == '$') {
                    return true;
                }
            }
            return false;
        }
        
        // search the current character
        for (int i = 0; i < root.next.size(); i++) {
            if (root.next.get(i).val == word.charAt(curIndex)) {
                return searchHelper(root.next.get(i), word, curIndex + 1);
            } 
            
            // the case that matches '.', '$' means the end not a match
            else if (root.next.get(i).val != '$' && word.charAt(curIndex) == '.') {
                if (searchHelper(root.next.get(i), word, curIndex + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

class TrieNode {
    // Initialize your data structure here.
    char val = '#';
    ArrayList<TrieNode> next = new ArrayList<TrieNode>();
    
    public TrieNode() { 
    }
    
    public TrieNode(char val) {
        this.val = val;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    // search word until the end, return the TrieNode if not found
    private TrieNode searchHelper(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            int curCharIndex = -1;
            
            for (int j = 0; j < cur.next.size(); j++) {
                if (cur.next.get(j).val == word.charAt(i)) {
                    curCharIndex = j;
                    break;
                }
            }
            
            if (curCharIndex == -1) {
                return null;
            }
            else {
                cur = cur.next.get(curCharIndex);
            }
        }
        
        return cur;
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode finalNode = searchHelper(word);
        
        if (finalNode == null) {
            return false;
        }
        
        for(TrieNode temp : finalNode.next) {
            if (temp.val == '$') {
                return true;
            }
        }
        
        return false;
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchHelper(prefix) != null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> visitedWords = new HashSet<String>();
        Queue<String> wordsQueue = new LinkedList<String>();
        int curLen = 0;
        
        wordsQueue.offer(beginWord);
        visitedWords.add(beginWord);
        
        while (wordsQueue.size() != 0) {
            curLen++;
            int levelSize = wordsQueue.size();
            
            for (int j = 0; j < levelSize; j++) {
                String word = wordsQueue.poll();
                if (word.equals(endWord)) {
                    return curLen;
                }
                
                // add word of one difference
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    for (char alpha = 'a'; alpha <= 'z'; alpha++) {
                        if (alpha != word.charAt(i)) {
                            wordArray[i] = alpha;
                            String tempString = String.valueOf(wordArray);
                            if (wordList.contains(tempString) && !visitedWords.contains(tempString)) {
                                visitedWords.add(tempString);
                                wordsQueue.offer(tempString);
                            }
                        }
                    }
                    
                    wordArray[i] = word.charAt(i);
                }
            }
        }
        
        return 0;
    }
}

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        // count number of papers for each citation
        int[] numCitations = new int[n + 1];
        Arrays.fill(numCitations, 0);
        for(int citation: citations) {
            if(citation >= n){
                numCitations[n]++;
            }
            else{
                numCitations[citation]++;
            }
        }
        
        // find the final hindex number
        int numPapers = 0;
        for(int i = n; i >= 0 ; i--) {
            numPapers += numCitations[i];
            if(numPapers >= i){
                return i;
            }
        }
        
        return 0;
        
    }
}

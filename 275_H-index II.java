public class Solution {
    public int hIndex(int[] citations) {
        int numPapers = 0;
        for(int i = citations.length - 1; i >=0; i--) {
            if(numPapers < citations[i]){
                numPapers++;
            }
            else{
                break;
            }
        }
        return numPapers;
    }
}

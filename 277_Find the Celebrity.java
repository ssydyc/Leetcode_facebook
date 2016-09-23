/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n == 0) {
            return -1;
        }
        
        // find a candidate
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (!knows(i, candidate)) {
                candidate = i;
            }
        }
        
        // check whehter the candidate is celebrity
        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }
            if (!knows(i, candidate) || knows(candidate, i)) {
                return -1;
            }
        }
        
        return candidate;
    }
}

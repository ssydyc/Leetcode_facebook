class Element {
    int row;
    int col;
    int val;
    
    public Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class Solution {
    private void createMatrix (int[][] A, ArrayList<Element> sparseA) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    sparseA.add(new Element(i, j, A[i][j]));
                }
            }
        }
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
         int[][] res = new int[A.length][B[0].length]; 
         ArrayList<Element> sparseA = new ArrayList<Element>();
         ArrayList<Element> sparseB = new ArrayList<Element>();
         
         createMatrix(A, sparseA);
         createMatrix(B, sparseB);
         
         for (int i = 0; i < sparseA.size(); i++) {
             for (int j = 0; j < sparseB.size(); j++) {
                 Element curA = sparseA.get(i);
                 Element curB = sparseB.get(j);
                 if (curA.col == curB.row) {
                     res[curA.row][curB.col] += curA.val * curB.val;
                 }
             }
         }
         
         return res;
         
    }
}

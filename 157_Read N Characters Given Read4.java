/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int cur = 0;
        int numRead;
        char[] buffer4 = new char[4];
        
        while ((numRead = read4(buffer4)) > 0) {
            for (int i = 0; i < numRead; i++) {
                if (cur == n) {
                    return n;
                }
                
                buf[cur++] = buffer4[i];
            }
        }
        
        return cur;
        
    }
}

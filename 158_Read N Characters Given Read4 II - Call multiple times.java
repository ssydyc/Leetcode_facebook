/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    Queue<Character> buffer4 = new LinkedList<Character>();
    
    public int read(char[] buf, int n) {
        int cur = 0;
        
        // read data from the buffer
        while (buffer4.size() > 0) {
            if (cur == n) {
                return n;
            }
            
            buf[cur++] = buffer4.poll();
        }
        
        // read data from file
        char[] tempBuffer4 = new char[4];
        int readSize = 0;
        
        while ((readSize = read4(tempBuffer4)) != 0) {
            for (int i = 0; i < readSize; i++) {
                if (cur == n) {
                    buffer4.offer(tempBuffer4[i]);
                } else {
                    buf[cur++] = tempBuffer4[i];
                }
            }
        }
        
        return cur;
        
    }
}

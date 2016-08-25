import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_708A{
    /* START OF I/O ROUTINE */
    // PrintWriter for faster output
    public static PrintWriter out;
      
    // MyInputReader class for faster input
    public static class MyInputReader {
        BufferedReader br;
        StringTokenizer st;

        public MyInputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
               str = br.readLine();
            } catch (IOException e) {
               e.printStackTrace();
            }
            return str;
        }
    } // end of class MyInputReader
    /* END OF I/O ROUTINE */
    
    public static void main(String[] args) {
        MyInputReader in = new MyInputReader(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out));

        String s = in.next();
        char s2[] = s.toCharArray();
        boolean changed = false;
        
        for(int i=0; i<s2.length; i++) {
            if(s2[i] == 'a' && changed) break;
            if(s2[i] != 'a') {
                s2[i] = (char)((int)s2[i] - 1);
                changed = true;
            }
        }
        if(!changed) s2[s2.length - 1] = 'z';

        out.println(s2);
        out.close();
    } // end of method main()
} // end of class Main
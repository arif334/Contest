import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_707C{
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

        long n = in.nextLong();
        
        if(n < 3) {
            out.println(-1);
        }
        else {
            long b, c;
            if(n%2 == 1) {
                b = (n*n - 1) / 2; 
                c = (n*n + 1) / 2; 
            }
            else {
                b = (n * n) / 4 - 1; 
                c = (n * n) / 4 + 1; 
            }
            out.println(b + " " + c);
        }

        out.close();
    } // end of method main()
} // end of class Main
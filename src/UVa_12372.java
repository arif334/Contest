import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class UVa_12372{
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
        
        int tc = in.nextInt();
        for(int cn = 1; cn <= tc; cn++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            
            String ans = "";
            if(a <= 20 && b <= 20 && c <= 20) {
                ans = "good";
            }
            else {
                ans = "bad";
            }
            
            out.format("Case %d: %s\n", cn, ans);
        }

        out.close();
    } // end of method main()
} // end of class Main
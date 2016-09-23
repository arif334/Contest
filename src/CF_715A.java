import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_715A{
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

        int n = in.nextInt();
        long ans[] = new long[n+2];
        ans[1] = 2;
        for(int i=2; i<=n; i++) {
            //long p = i * (i+1);
            //p = (p * p) - ((i-1) * (i));
            BigInteger p = new BigInteger(String.valueOf(i));
            p = p.multiply(new BigInteger(String.valueOf(i+1)));
            p = p.pow(2);
            p = p.subtract(new BigInteger(String.valueOf((long)(i-1) * (long)i)));
            p = p.divide(new BigInteger(String.valueOf(i)));
            ans[i] = p.longValue();
        }
        
        for(int k=1; k<=n; k++)
            out.println(ans[k]);

        out.close();
    } // end of method main()
} // end of class Main
import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_699A{
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
        String s = in.next();
        int[] x = new int[n];
        for(int i=0; i<n; i++) x[i] = in.nextInt();
        
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<n; i++) {
            if(s.charAt(i-1)=='R' && s.charAt(i)=='L')
                ans = Integer.min(ans, (x[i] - x[i-1])/2);
        }
        if(ans == Integer.MAX_VALUE) ans = -1;

        out.println(ans);
        out.close();
    } // end of method main()
} // end of class Main
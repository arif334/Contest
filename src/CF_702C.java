import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_702C{
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

        int i, j;
        
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n]; 
        int[] b = new int[m];
        for(i=0; i<n; i++) a[i] = in.nextInt();
        for(i=0; i<m; i++) b[i] = in.nextInt();
        
        int ans = 0;
        for(int x : a) {
            int pos = Arrays.binarySearch(b, x);
            if(pos >= 0) continue;
            
            int L = -pos - 2;
            int R = L + 1;
            int lDist = (L >= 0) ? x - b[L] : Integer.MAX_VALUE;
            int rDist = (R < m) ? b[R] - x : Integer.MAX_VALUE;
            int nearest = Integer.min(lDist, rDist);
            ans = Integer.max(ans, nearest);
        }
        
        out.println(ans);
        out.close();
    } // end of method main()
} // end of class Main
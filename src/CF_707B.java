import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_707B{
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
        int m = in.nextInt();
        int k = in.nextInt();
        
        boolean isFractory[] = new boolean[n+1];
        int g[][] = new int[m+1][3];
        int i, j, u, v, w;
        
        for(i=0; i<m; i++) {
            g[i][0] = in.nextInt();
            g[i][1] = in.nextInt();
            g[i][2] = in.nextInt();
        }
        for(i=0; i<k; i++) {
            j = in.nextInt();
            isFractory[j] = true;
        }
        
        int ans = Integer.MAX_VALUE;
        for(i=0; i<m; i++) {
            if(isFractory[g[i][0]] ^ isFractory[g[i][1]])
                ans = Integer.min(ans, g[i][2]);
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        
        out.println(ans);
        out.close();
    } // end of method main()
} // end of class Main
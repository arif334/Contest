import java.io.*;
import java.util.*;
 
/**
 * Algo: DP
 * Difficulty: Medium
 * @author arif_
 */
public class CF_615B{
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
        
        ArrayList<Integer> G[] = new ArrayList[n + 1];
        for(int i=1; i<=n; i++) {
            G[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            G[u].add(v);
            G[v].add(u);
        }
        
        int dp[] = new int[n + 1];
        long ans = -1;
        for(int u=1; u<=n; u++) {
            dp[u] = 1;
            for(int v : G[u]) {
                if(u > v) {
                    dp[u] = Math.max(dp[u], dp[v]+1);
                }
            }
            ans = Math.max(ans, dp[u] * (long)G[u].size());
        }
        
        out.println(ans);
        out.close();
    } // end of method main()
} // end of class Main
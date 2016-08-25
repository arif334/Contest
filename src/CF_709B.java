import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_709B{
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
        long a = in.nextLong();
        int m = n - 1;
        long ans = Integer.MAX_VALUE;
        List<Long> x = new ArrayList<>();
        long prefixSum[] = new long[n+2];
        long suffixSum[] = new long[n+2];
        int i, j;
        long k;
        for(i=0; i<n; i++) {
            k = in.nextLong();
            if(k == a) {
                m--;
            }
            else {
                x.add(k);
            }
        }
        n = x.size();
        
        if(m <= 0) out.println(0);
        else {
            Collections.sort(x);
            
            for(i=0; i<n && x.get(i)<a; i++) {}
            int prefixTotal = i;
            if(prefixTotal > 0) {
                prefixSum[1] = a - x.get(prefixTotal - 1);
                for(i=2, j=prefixTotal-1; i<=prefixTotal; i++, j--) {
                    prefixSum[i] = prefixSum[i-1] + (x.get(j) - x.get(j-1));
                }
            }
                        
            int suffixTotal = n - prefixTotal;
            if(suffixTotal > 0) {
                suffixSum[1] = x.get(prefixTotal) - a;
                for(i=prefixTotal+1, j=2; i<n; i++, j++) {
                    suffixSum[j] = suffixSum[j-1] + (x.get(i) - x.get(i-1));
                }
            }
                        
            for(i=1; i<=prefixTotal; i++) {
                j = m - i;
                if(j > suffixTotal || j < 0) continue;
                if(j == 0) ans = Math.min(ans, prefixSum[i]);
                else ans = Math.min(ans, prefixSum[i] * 2 + suffixSum[j]);
            }
            for(i=1; i<=suffixTotal; i++) {
                j = m - i;
                if(j > prefixTotal || j < 0) continue;
                if(j == 0) ans = Math.min(ans, suffixSum[i]);
                else {
                    try {
                        ans = Math.min(ans, suffixSum[i] * 2 + prefixSum[j]);
                    } catch (Exception e) {
                        out.println("i = " + i + " j = " + j);
                    }
                }
            }
            out.println(ans);
        }

        out.close();
    } // end of method main()
} // end of class Main
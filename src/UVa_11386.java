import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class UVa_11386{
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

        String text;
        int n;
        while((text = in.nextLine()) != null) {
            if(text.isEmpty()) break;
            n = Integer.parseInt(text);
            long a[] = new long[n];
            HashMap<Long, Long> hm = new HashMap<>();
            for(int i=0; i<n; i++) {
                a[i] = in.nextLong();
                hm.put(a[i], hm.getOrDefault(a[i], 0L) + 1);
            }
            
            long ans = 0;
            for(int i=0; i<n; i++) {
                for(int j=i+1; j<n; j++) {
                    ans += hm.getOrDefault(a[i] + a[j], 0L);
                }
            }
            
            out.println(ans);
        }

        out.close();
    } // end of method main()
} // end of class Main
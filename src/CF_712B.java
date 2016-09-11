import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_712B{
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
        char c[] = s.toCharArray();
        
        int ans = 0, n = s.length();
        
        if(n%2 == 1) ans = -1;
        else {
            int l = 0, r = 0, u = 0, d = 0;
            for(int i=0; i<n; i++) {
                if(c[i] == 'L') l++;
                if(c[i] == 'R') r++;
                if(c[i] == 'U') u++;
                if(c[i] == 'D') d++;
            }
            int ud = Math.abs(u -d);
            int rl = Math.abs(r - l);
            if(ud % 2 == 1) {
                ans = 1 + (ud/2) + (rl/2);
            }
            else
                ans = (ud/2) + (rl/2);
        }
        
        out.println(ans);
        out.close();
    } // end of method main()
} // end of class Main
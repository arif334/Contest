import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 * Algo: Greedy
 * Level: Medium
 */
public class CF_712C{
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

        int x = in.nextInt();
        int y = in.nextInt();
        
        int a[] = new int[3];
        Arrays.fill(a, y);
        
        int ans = 0;
        while(true) {
            Arrays.sort(a);
            if(a[0] >= x) break;
            a[0] = a[1] + a[2] - 1;
            ans++;
        }
        
        out.println(ans);
        out.close();
    } // end of method main()
} // end of class Main
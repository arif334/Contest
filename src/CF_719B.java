import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_719B{
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
        StringBuilder s = new StringBuilder(in.next());
        
        int red = 0, black = 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(i%2==0 && s.charAt(i)!='r') red++;
            if(i%2==1 && s.charAt(i)!='b') black++;
        }
        ans = Math.max(red, black);
        
        red = 0;
        black = 0;
        for(int i=0; i<n; i++) {
            if(i%2==0 && s.charAt(i)!='b') black++;
            if(i%2==1 && s.charAt(i)!='r') red++;
        }
        ans = Math.min(ans, Math.max(red, black));
        
        out.println(ans);
        out.close();
    } // end of method main()
} // end of class Main
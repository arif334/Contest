import java.io.*;
import java.util.*;
 
 
public class CF_71A{
    /* START OF IO ROUTINE */
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
      
    //-----------MyInputReader class for faster input----------
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
    /* END OF IO ROUTINE */
    
    public static void main(String[] args) {
        MyInputReader in = new MyInputReader(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int n = in.nextInt();
        while(n-- > 0) {
            String s = in.nextLine();
            int len = s.length();
            if(len > 10) {
                String ans = s.charAt(0) + Integer.toString(len-2) + s.charAt(len-1);
                out.println(ans);
            } else {
                out.println(s);
            }
        }
        
        out.close();
    } // end of method main()
} // end of class Main
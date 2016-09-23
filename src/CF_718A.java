import java.io.*;
import java.util.*;
import javax.crypto.spec.PSource;
 
/**
 * 
 * @author arif_
 */
public class CF_718A{
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
        int t = in.nextInt();
        StringBuilder s = new StringBuilder(in.next());
        
        int dotPos = 0;
        int i = 0;
        while(s.charAt(i) != '.') {
            i++;
        }
        dotPos = i;
        
        i++;
        while(i<n && s.charAt(i)<'5') {
            i++;
        }
        if(i == n) {
            out.println(s);
            out.close();
            System.exit(0);
        }
        
        int pos = i - 1;
        boolean leadingOne = false;
        while(t > 0) {
            if(s.charAt(pos) == '.')
                pos--;
            //out.println("pos: " + pos);
            int carry = 1;
            for(i=pos; i>=0; i--) {
                int c = (int)(s.charAt(i) - '0') + carry;
                //out.println("c: " + c);
                if(c == 10) {
                    s.setCharAt(i, '0');
                    carry = 1;
                    if(i == 0) leadingOne = true;
                    //out.println("we are here");
                    if(pos > dotPos) pos--;
                }
                else {
                    s.setCharAt(i, (char)(c + 48));
                    break;
                }
            }
            
            if(pos < dotPos) break;
            t--; if(t == 0) break;
            if(pos > dotPos) {
                if(s.charAt(pos) < '5') break;
                else pos--;
            }
        }
        
        if(leadingOne) out.print("1");
        if(s.charAt(dotPos+1)=='0' && pos==dotPos+1)
            out.println(s.substring(0, dotPos));
        else
            out.println(s.substring(0, pos+1));
        out.close();
    } // end of method main()
} // end of class Main
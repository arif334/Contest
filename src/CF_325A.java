import com.oracle.jrockit.jfr.DataType;
import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_325A{
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
            return st.nextToken().intern();
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
            return str.intern();
        }
    } // end of class MyInputReader
    /* END OF I/O ROUTINE */
    
    public static void main(String[] args) {
        MyInputReader in = new MyInputReader(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = in.nextInt();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        int x1, y1, x2, y2, area = 0;
        while(n-- > 0) {
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);
            area += ((x2 - x1) * (y2 - y1));
        }
        
        int expectedArea = (maxX - minX) * (maxY - minY);
        if(area == expectedArea && maxX-minX == maxY-minY) 
            out.println("YES");
        else 
            out.println("NO");

        out.close();
    } // end of method main()
} // end of class Main
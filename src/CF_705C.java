import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_705C{
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
        int q = in.nextInt();
        int unread[] = new int[n + 1];
        int last[] = new int[n + 1];
        int events[] = new int[q + 1];
        int i, j, t, x, cleared = 0, total = 0;
        
        i = 1;
        while(q-- > 0) {
            t = in.nextInt();
            x = in.nextInt();
            if(t == 1) {
                unread[x]++;
                events[i++] = x;
                total++;
            }
            else if(t == 2) {
                total -= unread[x];
                unread[x] = 0;
                last[x] = i - 1;
            }
            else if(x > cleared) {
                for(j=cleared+1; j<=x; j++)
                    if(unread[events[j]] > 0 && last[events[j]] < j) {
                        unread[events[j]]--;
                        total--;
                    }
                cleared = x;
            }
            out.println(total);
        }
        
        out.close();
    } // end of method main()
} // end of class Main
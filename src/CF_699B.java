import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 */
public class CF_699B{
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

        int r = in.nextInt();
        int c = in.nextInt();
        String[] g = new String[r];
        for(int i=0; i<r; i++) g[i] = in.next();
        
        int total = 0;
        for(int i=0; i<r; i++) 
            for(int j=0; j<c; j++)
                if(g[i].charAt(j) == '*') total++;
        
        int[] rowSum = new int[r];
        int[] colSum = new int[c];
        for(int i=0; i<r; i++) {
            int sum = 0;
            for(int j=0; j<c; j++) 
                if(g[i].charAt(j) == '*') sum++;
            rowSum[i] = sum;
        }
        for(int j=0; j<c; j++) {
            int sum = 0;
            for(int i=0; i<r; i++)
                if(g[i].charAt(j) == '*') sum++;
            colSum[j] = sum;
        }
        
        String ans = "NO";
        int ai = 0, aj = 0;
        for(int i=0; i<r; i++) for(int j=0; j<c; j++) {
            int curr = rowSum[i] + colSum[j];
            if(g[i].charAt(j) == '*') curr--;
            if(curr == total) {
                ans = "YES";
                ai = i + 1;
                aj = j + 1;
                break;
            }
        }
        
        out.println(ans);
        if(ans.equals("YES")) out.println(ai + " " + aj);
        
        out.close();
    } // end of method main()
} // end of class Main
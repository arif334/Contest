import java.io.*;
import java.util.*;
 
/**
 * 
 * @author arif_
 * Problem: Non-Divisible Subset
 * Link: https://www.hackerrank.com/challenges/non-divisible-subset
 */
public class Solution{
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
//        MyInputReader in = new MyInputReader(System.in);
//        out = new PrintWriter(new BufferedOutputStream(System.out));
//
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int[] f = new int[k]; // frequency of a[i] % k
//        for(int i=0; i<n; i++) {
//            int a = in.nextInt();
//            f[a%k]++;
//        }
//        
//        int ans = (f[0] > 0) ? 1 : 0;
//        for(int i=1, j=k-1; i<j; i++, j--) {
//            ans += Math.max(f[i], f[j]);
//        }
//        if(k%2==0 && f[k/2]>0) ans++;
        
//        out.println(ans);
//        out.close();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] f = new int[k];
        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            f[a%k]++;
        }
        
        int ans = (f[0] > 0) ? 1 : 0;
        for(int i=1, j=k-1; i<j; i++, j--) {
            ans += Math.max(f[i], f[j]);
        }
        if(k%2==0 && f[k/2]>0) ans++;
        
        System.out.println(ans);
        
    } // end of method main()
} // end of class Main
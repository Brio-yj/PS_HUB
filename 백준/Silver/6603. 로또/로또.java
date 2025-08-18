
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] res = new int[6];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            else {
                solve(n,st);
                System.out.println();
            }
        }
    }
    public static void solve(int n,StringTokenizer st){
        arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
        comb(0,0,arr);
    }
    public static void comb(int start, int r, int[] arr){
        if(r==6){
            for(int num : res) System.out.print(num+" ");
            System.out.println();
            return;
        }
        for(int i=start;i<arr.length;i++){
            res[r]=arr[i];
            comb(i+1,r+1,arr);
        }
    }
}
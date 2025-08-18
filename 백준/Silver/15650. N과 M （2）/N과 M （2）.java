
import java.io.*;

public class Main {
    static int N;
    static int M;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split(" ");

        N = Integer.parseInt(srr[0]);
        M = Integer.parseInt(srr[1]);

        int[] arr = new int[N];
        int[] res = new int[M];

        for(int i=0;i<N;i++)arr[i]=i+1;
        comb(0,0,arr,res);
    }
    public static void comb(int start, int r, int[] arr,int[] res){
        if(r==M){
            for(int num:res)System.out.print(num+" ");
            System.out.println();
            return;
        }
        for(int i=start;i<arr.length;i++){
            res[r]=arr[i];
            comb(i+1,r+1,arr,res);
        }
    }
}

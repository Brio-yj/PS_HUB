import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = new long[100];
        arr[0]=1;arr[1]=1;arr[2]=1;
        arr[3]=2;arr[4]=2;
        for(int i=5;i<100;i++){
            arr[i]=arr[i-1]+arr[i-5];
        }
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(arr[num-1]);
        }
    }
}

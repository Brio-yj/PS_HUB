

import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[] arr,answer;
    static boolean[] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];

        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solve(0);
    }
    static void solve(int depth){
        if(depth==M){
            StringBuilder sb = new StringBuilder();
            for(int num:answer) sb.append(num).append(" ");
            System.out.println(sb.toString().trim());
            return;
        }

        int prev=-1;
        for(int i=0;i<N;i++){
            if(visit[i] || arr[i]==prev)continue;

            prev=arr[i];
            visit[i]=true;
            answer[depth]=arr[i];

            solve(depth+1);

            visit[i]=false;
        }
    }
}

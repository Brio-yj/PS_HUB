

import java.io.*;
import java.util.*;
public class Main {
    static int N,cnt;
    static int[] state,arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            cnt=0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            state = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++)arr[i]=Integer.parseInt(st.nextToken());
            for(int i=1;i<=N;i++)if(state[i]==0)dfs(i);
            System.out.println(N-cnt);
        }
    }
    static void dfs(int start){
        state[start] = 1;
        int nxt = arr[start];

        if(state[nxt]==0)dfs(nxt);
        else if(state[nxt]==1){   //사이클 완성
            cnt++;
            for(int i=nxt;i!=start;i=arr[i]) cnt++;
        }
        state[start]=2;
    }
}
/*
1 2 3
2 3 1
 */
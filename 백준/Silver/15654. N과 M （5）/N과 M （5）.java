

import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[] arr;
    static boolean[] visit;
    static List<List<Integer>> list = new ArrayList();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){arr[i] = Integer.parseInt(st.nextToken());}

        Arrays.sort(arr);
        visit = new boolean[N];

        solve(0,new ArrayList());
    }
    static void solve(int depth,List<Integer> temp){
        if(depth==M){
            StringBuilder sb = new StringBuilder();
            for(int num:temp) sb.append(num).append(" ");
            System.out.println(sb.toString().trim());
            return;
        }
        for(int i=0;i<N;i++){
            if(visit[i])continue;
            temp.add(arr[i]);
            visit[i]=true;
            solve(depth+1,temp);
            temp.remove(temp.size()-1);
            visit[i]=false;
        }
    }
}

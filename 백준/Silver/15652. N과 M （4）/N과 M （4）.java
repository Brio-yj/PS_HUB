

import java.io.*;
import java.util.*;
public class Main {
    static int N,M;

    static List<List<Integer>> list = new ArrayList();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        solve(1,0,new ArrayList());

        for(int i=0;i<list.size();i++){
            StringBuilder sb = new StringBuilder();
            for(int num:list.get(i)) sb.append(num).append(" ");
            System.out.println(sb.toString().trim());
        }
    }
    static void solve(int start,int depth,List<Integer> temp){
        if(depth==M){
            List<Integer> ll = new ArrayList(temp);
            ll.sort(null);
            list.add(ll);
            return;
        }
        for(int i=start;i<=N;i++){
            temp.add(i);
            solve(i,depth+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
/*
1부터 출발 => 중복 포함 dfs
    i=start
    i값 넣어서 재귀 돌리기


 */


import java.io.*;
import java.util.*;
public class Main {
    static int []rank,parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        rank = new int[N+1];
        parent = new int[N+1];
        for(int i=0;i<=N;i++) parent[i]=i;

        int[][] board = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(board[i][j]==1) uni(i,j);
            }
        }

        boolean same = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fi = Integer.parseInt(st.nextToken());
        for(int i=1;i<M;i++){
            int se = Integer.parseInt(st.nextToken());
            if(find(fi-1)!=find(se-1)) {
                same=false;
                break;
            }
        }
        if(same) System.out.println("YES");
        else System.out.println("NO");
    }
    static int find(int num){
        if(parent[num]==num) return num;
        return parent[num]=find(parent[num]);
    }
    static void uni(int u,int v){
        u = find(u);
        v = find(v);

        if(u==v) return;

        if     (rank[u]>rank[v]){parent[v]=u;}
        else if(rank[u]<rank[v]){parent[u]=v;}
        else{
            rank[u]++;
            parent[v]=u;
        }
    }
}


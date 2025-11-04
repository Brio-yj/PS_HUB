

import java.io.*;
import java.util.*;
public class Main {
    static int[] parent,rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0;i<=n;i++)parent[i]=i;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            solve(type,a,b);
        }
    }
    static void solve(int type,int a,int b){
        if(type==0){uni(a,b);}
        if(type==1){
            if(find(a)==find(b)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    static int find(int num){
        if(parent[num]==num) return num;
        return parent[num]=find(parent[num]);
    }
    static void uni(int u,int v){
        u = find(u);
        v = find(v);

        if(u==v) return;

        if     (rank[u]<rank[v]) parent[u]=v;
        else if(rank[u]>rank[v]) parent[v]=u;
        else{
            rank[u]++;
            parent[v]=u;
        }
    }
}

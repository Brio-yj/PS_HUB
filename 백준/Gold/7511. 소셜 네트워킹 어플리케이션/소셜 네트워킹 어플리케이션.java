

import java.io.*;
import java.util.*;
public class Main {
    static int[] parent,rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            System.out.println("Scenario "+t+":");
            int N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            rank = new int[N+1];
            for(int p=0;p<=N;p++)parent[p]=p;

            int K = Integer.parseInt(br.readLine());
            for(int k=0;k<K;k++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                uni(a,b);
            }

            int M = Integer.parseInt(br.readLine());
            for(int m=0;m<M;m++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                //System.out.println("find-a/find-b-> "+find(a)+" "+find(b));
                if(find(a)==find(b)) System.out.println(1);
                else System.out.println(0);
            }
            System.out.println();
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
        if      (rank[u]<rank[v]) parent[u]=v;
        else if (rank[u]>rank[v]) parent[v]=u;
        else{
            rank[u]++;
            parent[v]=u;
        }
    }
}

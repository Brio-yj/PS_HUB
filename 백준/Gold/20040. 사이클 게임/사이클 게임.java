
import java.io.*;
import java.util.*;
public class Main {
    static int[] parent,rank;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        rank = new int[N+1];
        parent = new int[N+1];
        for(int i=0;i<=N;i++)parent[i]=i;

        int answer=0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a)==find(b)){
                answer=i;
                break;
            }

            uni(a,b);
        }
        if(answer==0) System.out.println(answer);
        else    System.out.println(answer+1);
    }
    static int find(int num){
        if(parent[num]==num) return num;
        return parent[num]=find(parent[num]);
    }
    static void uni(int u,int v){
        u=find(u);
        v=find(v);

        if(u==v) return;

        if(rank[u]>rank[v]) parent[v]=u;
        if(rank[u]<rank[v]) parent[u]=v;
        else{
            rank[u]++;
            parent[v]=u;
        }
    }
}

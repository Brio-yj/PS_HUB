

import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int to,wei;
        Node(int to,int wei){
            this.to=to;
            this.wei=wei;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] goDist = new int[N+1];
        int[] coDist = new int[N+1];

        List<Node>[] goG = new ArrayList[N+1];
        List<Node>[] coG = new ArrayList[N+1];
        for(int i=0;i<=N;i++)goG[i] = new ArrayList<>();
        for(int i=0;i<=N;i++)coG[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            goG[a].add(new Node(b,c));
            coG[b].add(new Node(a,c));
        }
        dijkstra(goDist,goG,X,N);
        dijkstra(coDist,coG,X,N);

        int max=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            max=Math.max(max,goDist[i]+coDist[i]);
        }
        System.out.println(max);
    }
    static void dijkstra(int[] dist,List<Node>[] adj,int X,int N){
        for(int i=0;i<=N;i++) dist[i]=Integer.MAX_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.wei-b.wei);
        dist[X]=0;
        pq.add(new Node(X,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.wei==dist[cur.to]){
                for(Node nxt : adj[cur.to]){
                    if(cur.wei+nxt.wei<dist[nxt.to]) {
                        dist[nxt.to]=cur.wei+nxt.wei;
                        pq.add(new Node(nxt.to,dist[nxt.to]));
                    }
                }
            }
        }
    }
}

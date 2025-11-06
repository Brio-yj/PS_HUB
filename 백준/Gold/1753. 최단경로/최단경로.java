

import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int to, weight;
        Node(int to,int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public String toString(){
            return to+"/"+weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[] dist = new int[V+1];
        for(int i=0;i<=V;i++) dist[i]=Integer.MAX_VALUE;
        dist[K]=0;

        List<Node>[] adj = new List[V+1];
        for(int i=0;i<=V;i++) adj[i]=new ArrayList();

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v,w));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Node(K,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.to]==cur.weight){
                for(Node node : adj[cur.to]) {
                    //작으면 넣고 갱신
                    if(dist[node.to]>dist[cur.to]+node.weight){
                        dist[node.to]=dist[cur.to]+node.weight;
                        pq.add(new Node(node.to,dist[node.to]));
                    }
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}

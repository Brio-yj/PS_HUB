

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
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int[] pre  = new int[V+1];
        int[] dist = new int[V+1];
        for(int i=0;i<=V;i++) dist[i]=Integer.MAX_VALUE;

        List<Node>[] adj = new List[V+1];
        for(int i=0;i<=V;i++) adj[i]=new ArrayList();

        for(int i=0;i<E;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v,w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end   = Integer.parseInt(st.nextToken());

        dist[start]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.to]==cur.weight){
                for(Node node : adj[cur.to]) {
                    //작으면 넣고 갱신
                    if(dist[node.to]>dist[cur.to]+node.weight){
                        dist[node.to]=dist[cur.to]+node.weight;
                        pq.add(new Node(node.to,dist[node.to]));

                        pre[node.to]=cur.to;
                    }
                }
            }
        }

        int target = end;
        List<Integer> list = new ArrayList();

        while(true){
            list.add(target);
            if(target==start) break;
            target=pre[target];
        }
        Collections.reverse(list);

        System.out.println(dist[end]);
        System.out.println(list.size());
        StringBuilder sb =new StringBuilder();
        for(int num:list) sb.append(num).append(" ");
        System.out.println(sb.toString().trim());
    }
}

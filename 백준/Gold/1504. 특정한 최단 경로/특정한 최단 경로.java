
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
    static int N,M,answer,mid1,mid2;
    static int[] dist;
    static List<Node>[] adj;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        adj=new ArrayList[N+1];
        for(int i=0;i<=N;i++) adj[i]=new ArrayList();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b,c));
            adj[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        mid1 = Integer.parseInt(st.nextToken());
        mid2 = Integer.parseInt(st.nextToken());
        int answer1=solve(1,mid1,mid2,N);
        int answer2=solve(1,mid2,mid1,N);
        if(answer1!=-1 && answer2!=-1) System.out.println(Math.min(answer1,answer2));
        else if(answer1==-1) System.out.println(answer2);
        else if(answer2==-1) System.out.println(answer1);
        else System.out.println(-1);
    }

    static int solve(int a,int b,int c,int d){
        int A =dijkstra(a,b);
        int B =dijkstra(b,c);
        int C =dijkstra(c,d);
        if(A==-1 ||B==-1 ||C==-1) return -1;
        else return A+B+C;
    }
    static int dijkstra(int start,int end){
        dist=new int[N+1];
        for(int i=0;i<=N;i++)dist[i]=Integer.MAX_VALUE;
        dist[start]=0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.wei-b.wei);
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.wei==dist[cur.to]){
                for(Node nxt : adj[cur.to]){
                    if(dist[nxt.to]>cur.wei+nxt.wei){
                        dist[nxt.to]=cur.wei+nxt.wei;
                        pq.add(new Node(nxt.to,dist[nxt.to]));
                    }
                }
            }
        }
        if(dist[end]==Integer.MAX_VALUE) return -1;
        return dist[end];
    }
}


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
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[] dist;
    static int[][] board;
    static List<Node>[] adj;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        board= new int[N][M];
        dist = new int[N*M+1];
        adj = new ArrayList[N*M+1];
        for(int i=0;i<=N*M;i++)adj[i]=new ArrayList();
        for(int i=0;i<=N*M;i++)dist[i]=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j)-'0';
            }
        }

        int cur=1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int to=0;
                for(int d=0;d<4;d++){
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if(nr<0 || nr>=N || nc<0 ||nc>=M) continue;
                    //상,하,좌,우
                    if(d==0) to= cur -M;
                    if(d==1) to= cur +M;
                    if(d==2) to= cur -1;
                    if(d==3) to= cur +1;

                    adj[cur].add(new Node(to,board[nr][nc]));
                }
                cur++;
            }
        }
        //그래프 완성

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.wei-b.wei);
        dist[1]=0;

        pq.add(new Node(1,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.wei==dist[now.to]){
                for(Node nxt:adj[now.to]){
                    if(dist[nxt.to]>now.wei+nxt.wei){
                        dist[nxt.to]=now.wei+nxt.wei;
                        pq.add(new Node(nxt.to,dist[nxt.to]));
                    }
                }
            }
        }
        System.out.println(dist[N*M]);
    }
}

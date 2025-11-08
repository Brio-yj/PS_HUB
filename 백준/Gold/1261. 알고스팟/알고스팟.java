
import java.io.*;
import java.util.*;
public class Main {
    static class Point{
        int r,c;
        Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] board,dist;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        board= new int[N][M];
        dist = new int[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j)-'0';
                                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        Deque<Point> dq = new ArrayDeque();

        dq.add(new Point(0,0));
        dist[0][0]=0;

        while(!dq.isEmpty()){
            Point cur = dq.poll();

            for(int i=0;i<4;i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                int nd = dist[cur.r][cur.c]+board[nr][nc];
                if(nd<dist[nr][nc]){
                    dist[nr][nc]=nd;
                    if(board[nr][nc]==0) dq.addFirst(new Point(nr,nc));
                    if(board[nr][nc]==1) dq.addLast(new Point(nr,nc));
                }
            }
        }
        System.out.println(dist[N-1][M-1]);
    }
}

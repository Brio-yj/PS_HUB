
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
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int R,C;

    static int[][] board;
    static int[][] visit;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visit = new int[R][C];

        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                char ch = s.charAt(j);
                board[i][j]=ch-'0';
            }
        }
        solve();
        System.out.println(visit[R-1][C-1]);
    }
    public static void solve(){
        Queue<Point> q = new LinkedList();
        q.add(new Point(0,0));
        visit[0][0]=1;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0;i<4;i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                if(board[nr][nc]==0 || visit[nr][nc]!=0) continue;

                q.add(new Point(nr,nc));
                visit[nr][nc]=visit[cur.r][cur.c]+1;
            }
        }
    }
}

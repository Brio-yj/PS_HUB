
import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int r,c,time;
        Point(int r,int c,int time){
            this.r=r;
            this.c=c;
            this.time=time;
        }
    }
    static int N,M,CNT;
    static int max=Integer.MIN_VALUE;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static boolean[] alpha= new boolean [26];
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j);
            }
        }
        alpha[board[0][0]-'A']=true;
        dfs(new Point(0,0,CNT));
        System.out.println(max+1);
    }
    static void dfs(Point p){
        //System.out.println("dfs");
        max=Math.max(max,CNT);
        //System.out.println("max/cnt= "+max+" " +CNT);

        for(int i=0;i<4;i++) {
            int nr = p.r + dr[i];
            int nc = p.c + dc[i];

            if(nr <0 || nr>=N || nc<0 || nc>=M) continue;

            if(alpha[board[nr][nc]-'A']) continue;

            //System.out.println("now=> pr/pc= "+p.r+" "+p.c+" nr/nc= "+nr+" "+nc);
            alpha[board[nr][nc]-'A']=true;
            dfs(new Point(nr,nc,CNT++));
            alpha[board[nr][nc]-'A']=false;
            CNT--;
        }
    }
    static Boolean Block(Point p) {

        for (int i = 0; i < 4; i++) {
            int nr = p.r + dr[i];
            int nc = p.c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || alpha[board[nr][nc] - 'A']) {continue;}
            return false;
        }
        return true;
    }
}

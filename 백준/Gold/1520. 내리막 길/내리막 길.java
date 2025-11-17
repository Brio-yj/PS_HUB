

import java.io.*;
import java.util.*;
public class Main {
    static int M,N; //M=R,N=C
    static int[][] visit;
    static int[][] board;
    static int[] dr= {-1,1,0,0};
    static int[] dc= {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visit = new int[M][N];
        board = new int[M][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j]=num;
                visit[i][j]=-1;
            }
        }
        System.out.println(dfs(0,0));
    }
    static int dfs(int r,int c){
        if(r==M-1 && c==N-1) return 1;
        if(visit[r][c]!=-1) return visit[r][c];
        visit[r][c]=0;

        for(int i=0;i<4;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(nr<0 || nr>=M || nc<0|| nc>=N) continue;
            if(board[r][c]>board[nr][nc]) visit[r][c]+=dfs(nr,nc);
        }
        return visit[r][c];
    }
}


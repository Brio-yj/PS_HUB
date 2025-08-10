
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
    static Boolean swan=false;
    static int N,M,TIME;
    static int sr,sc,er,ec;
    static int[] swanArr={-1,-1};
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int[][] board;
    static int[][] visit;
    static int[][] sVisit;
    static Queue<Point> sq = new LinkedList();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visit = new int[N][M];
        sVisit = new int[N][M];

        Queue<Point> zq = new LinkedList();
        Queue<Point> oq = new LinkedList();
        List<Point> pList = new ArrayList();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'L') {
                    pList.add(new Point(i,j));
                    board[i][j] = 0;
                }
                if (s.charAt(j) == 'X') {
                    board[i][j] = 1;
                }
                else {
                    board[i][j] = 0;
                    visit[i][j] =1;
                    zq.add(new Point(i,j));
                }
            }
        }
        sr=pList.get(0).r;
        sc=pList.get(0).c;
        er=pList.get(1).r;
        ec=pList.get(1).c;
        sVisit[sr][sc]=1;
        sq.add(new Point(sr,sc));
        while(true){
            while(!zq.isEmpty()){
                Point p = zq.poll();
                for(int i=0;i<4;i++){
                    int nr = p.r+dr[i];
                    int nc = p.c+dc[i];
                    if(nr<0 || nr >=N || nc<0 || nc>=M || visit[nr][nc]!=0) continue;

                    if(board[nr][nc]==1) {
                        //System.out.println("p.r/p.c= "+p.r+" "+p.c);
                        //System.out.println("nr/nc= "+nr+" "+nc);
                        board[nr][nc]=0;    // 여기 좀 의심 하긴 해야할듯 보드를 변경한다?
                        visit[nr][nc]=1;    // 여기 좀 의심 하긴 해야할듯 보드를 변경한다?
                        oq.add(new Point(nr,nc));
                    }
                    else if(board[nr][nc]==0) {
                        //System.out.println("p.r/p.c= "+p.r+" "+p.c);
                        //System.out.println("nr/nc= "+nr+" "+nc);

                        visit[nr][nc]=1;
                        zq.add(new Point(nr,nc));
                    }
                }
            }
            if(Meet()) break;
            TIME++;
            int oqSize = oq.size();
            for(int j=0;j<oqSize;j++){
                Point p = oq.poll();
                for(int i=0;i<4;i++){
                    int nr = p.r+dr[i];
                    int nc = p.c+dc[i];
                    if(nr<0 || nr >=N || nc<0 || nc>=M || visit[nr][nc]!=0) continue;

                    if(board[nr][nc]==1) {
                        //System.out.println("p.r/p.c= "+p.r+" "+p.c);
                        //System.out.println("nr/nc= "+nr+" "+nc);

                        board[nr][nc]=0;    // 여기 좀 의심 하긴 해야할듯 보드를 변경한다?
                        visit[nr][nc]=1;
                        oq.add(new Point(nr,nc));
                    }
                    else if(board[nr][nc]==0) {
                        //System.out.println("p.r/p.c= "+p.r+" "+p.c);
                        //System.out.println("nr/nc= "+nr+" "+nc);

                        visit[nr][nc]=1;
                        zq.add(new Point(nr,nc));
                    }
                }
            }
        }
        System.out.println(TIME+1);
    }
    static Boolean Meet(){
        //System.out.println("start meet----------");
        Queue<Point> q = new LinkedList();
        while(!sq.isEmpty()){   //static에서 관리되는(저장된) 큐에서 지역(실행될) 큐로 옮긴다.
            Point p = sq.poll();
            q.add(p);
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            if(board[p.r][p.c]==1) continue;    //얼어 있으면 아직 못간다
            for(int i=0;i<4;i++){
                int nr = p.r+dr[i];
                int nc = p.c+dc[i];
                if(nr==er && nc==ec) {
                    //System.out.println("meet");
                    return true;
                }
                if(nr<0 || nr >=N || nc<0 || nc>=M || sVisit[nr][nc]!=0) continue;
                if(board[nr][nc]==1){
                    sVisit[nr][nc]=1;
                    sq.add(new Point(nr,nc));
                }
                //System.out.println("p.r/p.c= "+p.r+" "+p.c);
                //System.out.println("nr/nc= "+nr+" "+nc);

                sVisit[nr][nc]=1;
                q.add(new Point(nr,nc));
            }
        }
        //System.out.println("dont meet=-------------------");
        return false;
    }
}

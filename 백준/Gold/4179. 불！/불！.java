
import java.util.*;
import java.io.*;
public class Main {
    static class Point{
        int r,c;
        Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    static int R,C,cnt;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] board;
    static int[][] jVisit;
    static int[][] fVisit;
    static Queue<Point> jQ = new LinkedList();
    static Queue<Point> fQ = new LinkedList();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board=new int[R][C];
        jVisit=new int[R][C];
        fVisit=new int[R][C];

        //#-2,F-1 Board
        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                if(s.charAt(j)=='#'){
                    board[i][j]=2;
                }
                if(s.charAt(j)=='F'){
                    fQ.add(new Point(i,j));
                    fVisit[i][j]=1;
                    board[i][j]=1;
                }
                if(s.charAt(j)=='J'){
                    jQ.add(new Point(i,j));
                    jVisit[i][j]=1;
                    board[i][j]=0;
                }
                if(s.charAt(j)=='.'){
                    board[i][j]=0;
                }
            }
        }
        while(true){
            if(jQ.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                break;
            }
            moveF();
            if(moveJ()) break;
            cnt++;
        }
    }
    static boolean moveJ(){
        Queue<Point> q = new LinkedList();
        while(!jQ.isEmpty()){
            Point cur = jQ.poll();
            for(int i=0;i<4;i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if(nr<0 || nr>=R ||nc<0 ||nc>=C){
                    System.out.println(cnt+1);
                    return true;
                }
                if(jVisit[nr][nc]!=0 || board[nr][nc]!=0) continue;
                q.add(new Point(nr,nc));
                jVisit[nr][nc]=1;
            }
        }
        jQ=q;
        return false;
    }
    static boolean moveF(){
        Queue<Point> q = new LinkedList();
        while(!fQ.isEmpty()){
            Point cur = fQ.poll();
            for(int i=0;i<4;i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if(nr<0 || nr>=R ||nc<0 ||nc>=C){continue;}
                if(fVisit[nr][nc]!=0 || board[nr][nc]==2) continue;
                q.add(new Point(nr,nc));
                fVisit[nr][nc]=1;
                board[nr][nc]=1;
            }
        }
        fQ=q;
        return false;
    }
}

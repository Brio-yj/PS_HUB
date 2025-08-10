
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] visit;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], -1);
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j)== '#' || s.charAt(j)== '*') board[i][j] = 0;
                else board[i][j] = s.charAt(j)-'0';
            }
        }
        bfs(r1-1, c1-1);
        System.out.println(visit[r2-1][c2-1]+1);
    }

    static void bfs(int r, int c) {
        visit[r][c] = 0;
        Queue<Point> q = new LinkedList();
        q.add(new Point(r, c));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && visit[nr][nc] == -1) {
                    if (board[nr][nc] == 1) {
                        visit[nr][nc] = visit[cur.r][cur.c] + 1;

                        //System.out.println("cur.r/cur.c= "+cur.r+" "+cur.c);
                        //System.out.println("nr/nc= "+nr+" "+nc);
                        //System.out.println("visit[nr][nc]= "+visit[nr][nc]);
                        q.add(new Point(nr, nc));
                    }
                    else {
                        visit[nr][nc] = visit[cur.r][cur.c];
                        //System.out.println("cur.r/cur.c= "+cur.r+" "+cur.c);
                        //System.out.println("nr/nc= "+nr+" "+nc);
                        //System.out.println("visit[nr][nc]= "+visit[nr][nc]);

                        List<Point> pList=go(nr,nc);
                        for(Point p :pList){
                            q.add(p);
                        }
                    }
                }
            }
        }
    }

    static List<Point> go(int r, int c) {
        List<Point> pList = new ArrayList();

        Queue<Point> q = new LinkedList();
        q.add(new Point(r, c));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && visit[nr][nc] == -1) {
                    if(board[nr][nc] == 0){
                        visit[nr][nc]=visit[cur.r][cur.c];

                        //System.out.println("cur.r/cur.c= "+cur.r+" "+cur.c);
                        //System.out.println("nr/nc= "+nr+" "+nc);
                        //System.out.println("visit[nr][nc]= "+visit[nr][nc]);
                        q.add(new Point(nr,nc));
                    }
                    if(board[nr][nc] == 1){
                        visit[nr][nc]=visit[cur.r][cur.c]+1;

                        //System.out.println("cur.r/cur.c= "+cur.r+" "+cur.c);
                        //System.out.println("nr/nc= "+nr+" "+nc);
                        //System.out.println("visit[nr][nc]= "+visit[nr][nc]);
                        pList.add(new Point(nr,nc));
                    }
                }
            }
        }
        return pList;
    }
}

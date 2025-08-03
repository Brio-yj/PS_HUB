
import java.util.*;
import java.io.*;

public class Main {
    static class SCV{
        int f,s,t,idx;
        SCV(int f,int s,int t,int idx){
            this.f=f;
            this.s=s;
            this.t=t;
            this.idx=idx;
        }
    }
    static int[][] attack = {
            {1, 3, 9},
            {1, 9, 3},
            {3, 1, 9},
            {3, 9, 1},
            {9, 3, 1},
            {9, 1, 3}};
    static int N;
    static int[][][] hp = new int[61][61][61];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scv = {0, 0, 0};
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            scv[i] = num;
        }
        SCV s = new SCV(scv[0],scv[1],scv[2],0);
        System.out.println(bfs(s));
    }
    static int bfs(SCV s){
        Queue<SCV> q = new LinkedList();
        q.add(s);

        while(!q.isEmpty()) {
            SCV cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nf = cur.f - attack[i][0];
                int ns = cur.s - attack[i][1];
                int nt = cur.t - attack[i][2];

                if(nf<=0 && ns<=0 && nt<=0) return cur.idx+1;
                if(nf<=0) nf=0;
                if(ns<=0) ns=0;
                if(nt<=0) nt=0;
                if(hp[nf][ns][nt]!=0) continue;
                else{
                    hp[nf][ns][nt]=1;
                    q.add(new SCV(nf,ns,nt,cur.idx+1));
                }
            }
        }
        return -1;
    }
}

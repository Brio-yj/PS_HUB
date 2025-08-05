

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Person {
        int pos, time;
        Person(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    static int N, K, step;
    static boolean check=false;
    static int min = Integer.MAX_VALUE;
    static List<Integer> nList = new ArrayList();
    static int[] board = new int[1000001];
    static int[] visit = new int[1000001];
    static int[] parent = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(board,min);
        Arrays.fill(visit,min);
        System.out.println(step=bfs(new Person(N, 0)));
        visit[K]=0;
        dfs(0,K);
    }

    static int bfs(Person p) {
        Queue<Person> q = new LinkedList();
        board[p.pos]=0;
        q.add(p);
        while(!q.isEmpty()){
            Person cur = q.poll();
            if(cur.pos==K){
                return cur.time;
            }
            int[] dr = {cur.pos-1,cur.pos+1,cur.pos*2};
            for(int npos :dr){
                if(npos<0 || npos>1000000 || board[npos]<=board[cur.pos]) continue;
                else{
                    board[npos]=board[cur.pos]+1;
                    q.add(new Person(npos,cur.time+1));
                }
            }
        }
        return 0;
    }
    static void dfs(int depth,int cur){
        if(depth==step){   //스텝 동일한지 N에 도착했는지
            if(cur==N){
                nList.add(N);
                StringBuilder sb = new StringBuilder();
                for(int i=nList.size()-1;i>=0;i--){
                    sb.append(nList.get(i)).append(" ");
                }
                System.out.println(sb.toString().trim());
                System.exit(0);
            }
            return;
        }
        int[] dpos = {cur-1,cur+1,cur/2};

        for(int npos : dpos){
            if(npos>=0 && npos<=1000000 && board[npos]==board[cur]-1 && visit[npos]>visit[cur]){
                //System.out.println("visit[nps]= "+ visit[npos]+", visit[start]= "+visit[start]);
                visit[npos]=visit[cur]+1;
                nList.add(cur);
                dfs(depth+1,npos);
                nList.remove(nList.size()-1);
            }
        }
    }
}

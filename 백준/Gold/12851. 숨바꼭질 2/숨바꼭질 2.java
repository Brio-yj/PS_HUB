
import java.io.*;
import java.util.*;

public class Main {
    static class Person {
        int pos, time;

        Person(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    static int N, K, count;
    static int min = Integer.MAX_VALUE;
    static int[] board = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(board,min);
        bfs(new Person(N, 0));
        System.out.println(min);
        System.out.println(count);
    }

    static void bfs(Person p) {
        Queue<Person> q = new LinkedList();
        q.add(p);
        board[p.pos]=0;
        while (!q.isEmpty()) {
            Person cur = q.poll();
            if (cur.pos == K) {
                min = cur.time;
                count++;
            }
            if (cur.time >= min) continue;

            if (cur.pos - 1 >= 0 && cur.pos - 1 <= 1000000 && board[cur.pos - 1] > board[cur.pos]) {
                board[cur.pos-1]=board[cur.pos]+1;
                q.add(new Person(cur.pos - 1, cur.time + 1));
            }
            if (cur.pos + 1 >= 0 && cur.pos + 1 <= 1000000 &&  board[cur.pos + 1] > board[cur.pos]) {
                board[cur.pos+1]=board[cur.pos]+1;
                q.add(new Person(cur.pos + 1, cur.time + 1));
            }
            if (cur.pos * 2 >= 0 && cur.pos * 2 <= 1000000 &&  board[cur.pos * 2] > board[cur.pos]) {
                board[cur.pos*2]=board[cur.pos]+1;
                q.add(new Person(cur.pos * 2, cur.time + 1));
            }
        }
    }
}



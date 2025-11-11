

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int max = 100_000;
    static int[] arr = new int[max + 1];
    static boolean[] visit = new boolean[max + 1];
    static Queue<Integer> q = new LinkedList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= max; i++) arr[i] = Integer.MAX_VALUE;
        arr[K] = 0;
        visit[K] = true;
        q.add(K);
        while (true) {
            int num = q.poll();
            //System.out.println("now=> " + num);
            if (num == N) break;
            solve(num);
        }
        System.out.println(arr[N]);
    }

    static void solve(int num) {
        if (num % 2 == 0) {
            if (num >= 1 && num <= max) {
                arr[num - 1] = Math.min(arr[num - 1], arr[num] + 1);
                if (!visit[num - 1]) {
                    q.add(num - 1);
                    visit[num - 1] = true;
                }
            }
            if (num >= 0 && num <= max - 1) {
                arr[num + 1] = Math.min(arr[num + 1], arr[num] + 1);
                if (!visit[num + 1]) {
                    q.add(num + 1);
                    visit[num + 1] = true;
                }
            }
            if (num <= max) {
                arr[num / 2] = Math.min(arr[num / 2], arr[num]);
                if (!visit[num / 2]) {
                    q.add(num / 2);
                    visit[num / 2] = true;
                }
            }
            //System.out.println("num-1/num+1/num/2 = " + arr[num - 1] + " " + arr[num + 1] + " " + arr[num / 2]);
        }
        else {
            if (num >= 1 && num <= max) {
                arr[num - 1] = Math.min(arr[num - 1], arr[num] + 1);
                if (!visit[num - 1]) {
                    q.add(num - 1);
                    visit[num - 1] = true;
                }
            }
            if (num >= 0 && num <= max - 1) {
                arr[num + 1] = Math.min(arr[num + 1], arr[num] + 1);
                if (!visit[num + 1]) {
                    q.add(num + 1);
                    visit[num + 1] = true;
                }
            }
            //System.out.println("num-1/num+1 = " + arr[num - 1] + " " + arr[num + 1]);
        }
    }
}

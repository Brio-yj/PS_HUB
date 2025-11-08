

import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N==1) {
            System.out.println(0);
            System.exit(0);
        }
        arr = new int[N + 1];
        List<Integer> list = new ArrayList();
        for (int i = 2; i <= N; i++) {if(isPrime(i)) list.add(i);}

        int size = list.size();
        int l = 0, r = 0, sum = 0, cnt=0;

        while (true) {
            if (sum >= N) {
                if (sum == N) cnt++;
                sum -= list.get(l++);
            } else {
                if (r == list.size()) break;
                sum += list.get(r++);
            }
        }
        System.out.println(cnt);
    }
    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

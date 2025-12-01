
import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> temp1 = new ArrayList();
            Set<Integer> set = new HashSet();

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                temp1.add(num);
                set.add(num);
            }
            List<Integer> temp2 = new ArrayList(set);
            temp2.sort(null);
            for(int j=0;j<N;j++) {
                arr[i][j]=Collections.binarySearch(temp2,temp1.get(j));
            }
        }

        int cnt = 0;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                boolean same = true;
                for (int k = 0; k < N; k++) {
                    if (arr[i][k]!=arr[j][k]) {
                        same = false;
                        break;
                    }
                }
                if (same) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
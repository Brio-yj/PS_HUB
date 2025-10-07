
import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> nList = new ArrayList<>();
    static List<Integer> mList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nList.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) mList.add(Integer.parseInt(st.nextToken()));

        nList.sort(Integer::compare);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mList.size(); i++) {
            sb.append(solve(mList.get(i), 0, nList.size() - 1) ? 1 : 0).append('\n');
        }
        System.out.print(sb);
    }

    static boolean solve(int num, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int v = nList.get(mid);
            if (v == num) return true;
            if (v < num) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}

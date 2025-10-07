
import java.io.*;
import java.util.*;
public class Main {
    static List<Integer> nList = new ArrayList();
    static List<Integer> mList = new ArrayList();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            nList.add(num);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            mList.add(num);
        }

        Collections.sort(nList);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<mList.size();i++) {
            int l = leftSearch(mList.get(i),0,nList.size());
            int r = rightSearch(mList.get(i),0,nList.size());
            sb.append(r-l).append("\n");
        }
        System.out.println(sb);

    }
    static public int leftSearch(int num, int lo, int hi){
        while(lo<hi){
            int mid = (hi+lo)/2;
            if(nList.get(mid)<num) lo = mid+1;
            else hi=mid;
        }
        return lo;
    }
    static public int rightSearch(int num, int lo, int hi){
        while(lo<hi){
            int mid = (hi+lo)/2;
            if(nList.get(mid)<=num) lo = mid+1;
            else hi=mid;
        }
        return lo;
    }
}

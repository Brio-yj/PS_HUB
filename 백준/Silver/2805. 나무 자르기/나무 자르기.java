

import java.io.*;
import java.util.*;
public class Main {
    static List<Integer> list = new ArrayList();
    static long n=0,m=0,answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st  = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){list.add(Integer.parseInt(st.nextToken()));}
        list.sort((a,b)->{return a-b;});

        long l=0,r=list.get(list.size()-1);
        while(l<=r){
            long mid = l + (r-l)/2;
            if(solve(mid)) {
                answer=mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        System.out.println(answer);
    }
    static boolean solve(long cut){
        long sum=0;
        for(int i=0;i<list.size();i++){
            long height = list.get(i)-cut;
            if(height>=0) sum+=height;
            if(sum>=m) return true;
        }
        return false;
    }
}
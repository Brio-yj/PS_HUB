
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static boolean[] visit=new boolean[10];
    static int[] irr=new int[10];
    static String[] srr;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static String minResult = "";
    static String maxResult = "";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        srr = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            srr[i]=st.nextToken().toString();
        }
        minDfs(0);
        Arrays.fill(visit, false);
        maxDfs(0);
        System.out.println(maxResult);
        System.out.println(minResult);
    }
    static boolean minDfs(int idx){
        if(idx==N+1){
            solve(0);
            return true;
        }
        for(int i=0;i<10;i++){
            if(visit[i]) continue;
            irr[idx]=i;
            visit[i]=true;
            if(idx==0) {
                if(minDfs(idx+1)) return true;
            }
            else if(comp(idx)) {
                if(minDfs(idx+1)) return true;
            }
            visit[i]=false;
        }
        return false;
    }
    static boolean maxDfs(int idx){
        if(idx==N+1){
            solve(1);
            return true;
        }
        for(int i=9;i>=0;i--){
            if(visit[i]) continue;
            irr[idx]=i;
            visit[i]=true;
            if(idx==0) {
                if(maxDfs(idx+1)) return true;
            }
            else if(comp(idx)) {
                if(maxDfs(idx+1)) return true;
            }
            visit[i]=false;
        }
        return false;
    }
    static boolean comp(int idx){
        if(srr[idx-1].equals(">")){
            //System.out.println(">/irr[idx-1]/srr[idx-1]/irr[idx]= "+idx+" "+irr[idx-1]+" "+srr[idx-1]+" "+irr[idx]+" ");
            if(irr[idx-1]>irr[idx]) return true;
        }
        if(srr[idx-1].equals("<")){
            //System.out.println("</irr[idx-1]/srr[idx-1]/irr[idx]= "+idx+" "+irr[idx-1]+" "+srr[idx-1]+" "+irr[idx]+" ");
            if(irr[idx-1]<irr[idx]) return true;
        }
        return false;
    }
    static void solve(int flag){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + 1; i++) {
            sb.append(irr[i]);
        }
        if(flag==0) minResult = sb.toString();
        if(flag==1) maxResult = sb.toString();
    }
}

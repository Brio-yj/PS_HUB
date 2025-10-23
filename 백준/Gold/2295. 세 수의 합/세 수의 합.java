

import java.io.*;
import java.util.*;
public class Main {
    static int max = Integer.MIN_VALUE;
    static Set<Integer> set = new HashSet();
    static List<Integer> list = new ArrayList();
    static List<Integer> twoList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){list.add(Integer.parseInt(br.readLine()));}
        sumTwo(0,0,0);
        twoList = new ArrayList(set);
        twoList.sort((a,b)->{return a-b;});
        //for(int l:twoList) System.out.print(l+" ");
        //System.out.println();

        solve();
        //System.out.println();
        System.out.println(max);
    }
    static void solve(){
        for(int i=0;i<list.size();i++){
            int fi =list.get(i);
            for(int j=0;j<list.size();j++){
                int se =list.get(j);
                //System.out.print(fi-se+ " ");
                if(Collections.binarySearch(twoList,fi-se)>=0) max = Math.max(max,fi);
            }
        }
    }
    static void sumTwo(int depth, int sum,int start){
        if(depth==2) {
            set.add(sum);
            return;
        }
        for(int i=start;i<list.size();i++){sumTwo(depth+1,sum+list.get(i),i);}
        return;
    }
}
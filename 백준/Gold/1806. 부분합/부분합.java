

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList();
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        int fi=0,se=0,min=Integer.MAX_VALUE,size=list.size(),sum=0;
        boolean moveS=true;
        while(fi<size && se<size){
            if(moveS) {sum+=list.get(se); moveS=false;}

            if(sum<m) {
                moveS=true;
                se++;
            }
            else{
                min=Math.min(se-fi+1,min);
                sum-=list.get(fi);
                fi++;
            }
        }
        if(min==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
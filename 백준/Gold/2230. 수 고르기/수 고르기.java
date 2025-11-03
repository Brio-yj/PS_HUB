import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList();
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        list.sort(null);
        int fi=0,se=0,min=Integer.MAX_VALUE;
        while(true){
            int fn = list.get(fi);
            int sn = list.get(se);

            if(sn-fn<m) {
                if(se==list.size()-1) break;
                se++;
            }
            else{
                min = Math.min(sn-fn,min);
                
                if(fi==list.size()-1) break;
                fi++;
            }
        }
        System.out.println(min);
    }
}


import java.io.*;
import java.util.*;
public class Main {
    static class Tuple{
        int idx,value;
        Tuple(int idx,int value){
            this.idx=idx;
            this.value=value;
        }
    }
    static Map<List<Integer>,Integer> map = new HashMap();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList();
        for(int i=0;i<r;i++)list.add(new ArrayList());

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());

            List<Tuple> tupleList = new ArrayList();
            for(int j=0;j<c;j++){
                int num = Integer.parseInt(st.nextToken());
                tupleList.add(new Tuple(j,num));
            }
            tupleList.sort((a,b)->{return a.value-b.value;});

            List<Integer> temp = new ArrayList(Collections.nCopies(c,0));

            int rank=0;
            temp.set(tupleList.get(0).idx,rank);
            for(int j=1;j<c;j++){
                if(tupleList.get(j).value!=tupleList.get(j-1).value) rank++;
                temp.set(tupleList.get(j).idx,rank);
            }

            map.merge(temp,1,(prev,now)->prev+now);
        }
        int cnt=0;
        for(int val : map.values()){
            cnt += val * (val - 1) / 2;
        }
        System.out.println(cnt);
    }
}

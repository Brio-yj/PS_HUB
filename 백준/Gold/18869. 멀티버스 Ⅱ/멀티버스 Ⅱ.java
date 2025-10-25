
import java.io.*;
import java.util.*;
public class Main {
    static class Tuple{
        int idx,value,rank;
        Tuple(int idx,int value){
            this.idx=idx;
            this.value=value;
            this.rank=0;
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
            List<Integer> beforeList = new ArrayList();
            List<Tuple> tupleList = new ArrayList();
            for(int j=0;j<c;j++){
                int num = Integer.parseInt(st.nextToken());
                beforeList.add(num);
                tupleList.add(new Tuple(j,num));
            }
            tupleList.sort((a,b)->{return a.value-b.value;});

            int Rank=0;
            tupleList.get(0).rank=Rank;
            for(int j=1;j<c;j++){
                if(tupleList.get(j).value!=tupleList.get(j-1).value) Rank++;
                tupleList.get(j).rank=Rank;
            }

            tupleList.sort((a,b)->{return a.idx-b.idx;});
            List<Integer> temp = new ArrayList();
            for(int j=0;j<c;j++) temp.add(tupleList.get(j).rank);

            map.merge(temp,1,(prev,now)->prev+now);
        }
        int cnt=0;
        for(int val : map.values()){
            cnt += val * (val - 1) / 2;
        }
        System.out.println(cnt);
    }
}

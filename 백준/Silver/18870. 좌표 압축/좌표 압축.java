
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> answerList = new ArrayList();
        List<Integer> list = new ArrayList();
        
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        
        Set<Integer> set = new HashSet(list);
        List<Integer> temp = new ArrayList(set);
        temp.sort((a,b)->{return a-b;});

        for(int i=0;i<list.size();i++){answerList.add(solve(list.get(i),temp));}

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<answerList.size();i++){sb.append(answerList.get(i)).append(" ");}
        System.out.println(sb.toString().trim());
    }
    static int solve(int num,List<Integer> temp){
        int l=0; int r=temp.size();
        while(l<r){
            int mid = l+(r-l)/2;
            if(num>temp.get(mid)) l = mid+1;
            else r = mid;
        }
        return l;
    }
}


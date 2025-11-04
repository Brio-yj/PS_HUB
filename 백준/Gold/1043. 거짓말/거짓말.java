

import java.io.*;
import java.util.*;
public class Main {

    static boolean[] answer;
    static Queue<Integer> q = new LinkedList();
    static List<List<Integer>> list = new ArrayList();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int  n = Integer.parseInt(st.nextToken());
        int  m = Integer.parseInt(st.nextToken());

        answer= new boolean[m];

        st = new StringTokenizer(br.readLine());
        int  t = Integer.parseInt(st.nextToken());

        //처음 진실 아는 사람
        if(t!=0){
            for(int i=0;i<t;i++){
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            }
        }

        //2차원 리스트 만들기
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int tempSize = Integer.parseInt(st.nextToken());

            List<Integer> tempList = new ArrayList();
            for(int j=0;j<tempSize;j++){
                int tempNum = Integer.parseInt(st.nextToken());
                tempList.add(tempNum);
            }
            tempList.sort(null);
            list.add(tempList);
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int num = q.poll();
                BS(num);
            }
        }

        int cnt=0;
        for(int i=0;i<m;i++)if(!answer[i]) cnt++;
        System.out.println(cnt);
    }
    static void BS(int num){
        for(int i=0;i<list.size();i++){
            if(!answer[i]){
                int idx = Collections.binarySearch(list.get(i),num);
                if(idx>=0){
                    for(int j=0;j<list.get(i).size();j++){
                        if(list.get(i).get(j)==num) continue;
                        else q.add(list.get(i).get(j));
                    }
                    answer[i]=true;
                }
            }
        }
    }
}
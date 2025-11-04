
import java.io.*;
import java.util.*;
public class Main {

    static boolean[] answer;
    static Deque<Integer> q = new ArrayDeque();
    static List<List<Integer>> list = new ArrayList();  //리스트
    static List<List<Integer>> party = new ArrayList(); //사람이 속해있는 파티 번호들

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int  n = Integer.parseInt(st.nextToken());
        int  m = Integer.parseInt(st.nextToken());

        answer= new boolean[m];
        for(int i=0;i<=n;i++)party.add(new ArrayList());

        st = new StringTokenizer(br.readLine());
        int  t = Integer.parseInt(st.nextToken());

        //처음 진실 아는 사람
        if(t!=0){
            for(int i=0;i<t;i++){
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            }
        }

        //입력 처리
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int tempSize = Integer.parseInt(st.nextToken());

            List<Integer> tempList = new ArrayList();
            for(int j=0;j<tempSize;j++){
                int tempNum = Integer.parseInt(st.nextToken());

                party.get(tempNum).add(i);
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
        for(int row : party.get(num)){
            if(!answer[row]) {
                answer[row] = true;
                for (int temp : list.get(row)) {
                    if (temp != num) q.add(temp);
                }
            }
        }
    }
}
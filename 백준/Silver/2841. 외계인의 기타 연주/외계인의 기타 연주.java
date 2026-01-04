
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int cnt = 0;

        List<Stack<Integer>> list = new ArrayList();
        for(int i=0;i<=N;i++) list.add(new Stack<Integer>());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(list.get(n).isEmpty()){
                list.get(n).push(p);
                cnt++;
            }
            else if(list.get(n).peek()<p){
                list.get(n).push(p);
                cnt++;
            }
            else if(list.get(n).peek()==p){
                continue;
            }
            else if(list.get(n).peek()>p){
                while(!list.get(n).isEmpty() && list.get(n).peek()>p){
                    list.get(n).pop();
                    cnt++;
                }
                if(list.get(n).isEmpty()){
                    list.get(n).push(p);
                    cnt++;
                }
                else if(list.get(n).peek()<p){
                    list.get(n).push(p);
                    cnt++;
                }
                else if(list.get(n).peek()==p){
                    continue;
                }
            }
        }
        System.out.println(cnt);
    }
}
/*
    들어오면 눌러야 한다
    끝나면 떼야하고
    낮은거 눌러야 할때는 높은거 누르고 있는거 전부 떼야한다
    N<=500000, P<=300000
    N개 STACK ARR만들고
        입력 확인
            해당 번호 스택 TOP 확인
            입력 프랫보다 작다
                그냥 PUSH & CNT
            입력 프랫보다 크다
                작아질때 까지 POP & CNT
            입력 프랫이랑 동일하다
                무시
 */
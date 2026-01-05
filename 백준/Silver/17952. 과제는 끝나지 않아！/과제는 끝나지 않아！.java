
import java.io.*;
import java.util.*;

public class Main {
    static class Task{
        int score, time;
        Task(int score,int time){
            this.score=score;
            this.time=time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Task> stack = new Stack();

        int answer =0;
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type==1){
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                stack.add(new Task(score,time));
            }
            if(!stack.isEmpty()) {
                Task cur = stack.peek();
                stack.pop();
                cur.time--;
                if (cur.time == 0) answer += cur.score;
                else stack.push(cur);
            }
        }
        System.out.println(answer);
    }
}

/*
차이가 없어 보이는데 뭔 차이지...
그냥 클래스 + STACK
전부 받고 스택에 넣은 다음 하나씩 처리 하기 vs

1 2 10
0 0
1 2 100

이런거 있으면 안된다 -> 바로 처리 해야함!
    type=1 -> 스택에 넣기
    type=0 -> 아무것도 안함
    여기서 한번에 처리


 */
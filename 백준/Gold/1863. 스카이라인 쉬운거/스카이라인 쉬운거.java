import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static Stack<Point> stack = new Stack();
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        int cnt = 0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) stack.push(new Point(X,Y));
            else{
                while(true){
                    if(stack.isEmpty()) {
                        stack.push(new Point(X, Y));
                        break;
                    }

                    Point cur = stack.peek();
                    if(cur.y>Y){
                        stack.pop();
                        cnt++;
                    }
                    else if(cur.y==Y) {
                        break;
                    }
                    else{
                        stack.push(new Point(X,Y));
                        break;
                    }
                }
            }
        }
        int size= stack.size();
        for(int i=0;i<size;i++){
            Point cur = stack.pop();
            if(cur.y!=0) cnt++;
        }
        System.out.println(cnt);
    }
}
//마지막에 같은거 들어오면 cnt++
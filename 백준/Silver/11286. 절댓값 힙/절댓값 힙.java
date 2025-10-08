
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if(Math.abs(a)==Math.abs(b)) {
                return Integer.compare(a,b);
            } else {
                return Integer.compare(Math.abs(a),Math.abs(b));
            }
        });
        
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                pq.add(num);
            } else {
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll()).append('\n');
                }
            }
        }
        System.out.print(sb.toString());
    }
}

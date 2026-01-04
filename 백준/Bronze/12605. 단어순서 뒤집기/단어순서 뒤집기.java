
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt =1;

        for(int i=0;i<N;i++){
            Stack<String> stack = new Stack();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(true){
                if(!st.hasMoreTokens()) break;
                String s = st.nextToken();
                stack.push(s);
            }
            String answer = new String();
            while(!stack.isEmpty()){
                String s = stack.pop();
                answer+= s;
                answer+= " ";
            }

            System.out.println("Case #"+cnt+": "+answer.trim());
            cnt++;
        }
    }
}

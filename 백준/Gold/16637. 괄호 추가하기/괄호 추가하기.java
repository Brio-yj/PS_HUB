
import java.io.*;

public class Main {
    
    static int N,max;
    static char cArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cArr = new char[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++) {cArr[i] = s.charAt(i);}
        max = Integer.MIN_VALUE;
        
        int res = cArr[0] - '0';
        solve(1,res);
        
        if(N==1){max = res;}        
        System.out.println(max);
    }

    static void solve(int idx,int res) {
        if (idx == N) {
            max = Math.max(max, res);
            return;
        }
        
        int nv = cal(res,cArr[idx],cArr[idx+1]-'0');
        solve(idx+2,nv);

        if(idx+4<=N) {
            nv = cal(res,cArr[idx],cal(cArr[idx+1]-'0', cArr[idx+2], cArr[idx +3]-'0'));
            solve(idx+4,nv);
        }
    }

    static int cal(int num1, char op, int num2) {
        if (op == '+') {
            return num1 + num2;
        }
        if (op == '-') {
            return num1 - num2;
        }
        if (op == '*') {
            return num1 * num2;
        }
        return 0;
    }
}
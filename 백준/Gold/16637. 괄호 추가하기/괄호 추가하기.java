import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int res, max;
    static char cArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cArr = new char[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            cArr[i] = s.charAt(i);
        }
        res = cArr[0] - '0';
        max = Integer.MIN_VALUE;
        if(N==1){
            System.out.println(s.charAt(0)-'0');
            return;
        }
        if(N==3){
            System.out.println(cal(0,1,2));;
            return;
        }
        solve(1);
        System.out.println(max);
    }

    static void solve(int idx) {   //괄호 안친다 =0, 친다=1
        if (idx == N) {
            max = Math.max(max, res);
            return;
        }
        if (idx % 2 == 1) {
            //안치기
            if (cArr[idx] == '+') {
                if(idx+2 <= N) {
                    res += (cArr[idx + 1] - '0');
                    solve(idx + 2);
                    res -= (cArr[idx + 1] - '0');
                }
                if (idx + 4 <= N) {
                    res += cal(idx + 1, idx + 2, idx + 3);
                    solve(idx + 4);
                    res -= cal(idx + 1, idx + 2, idx + 3);
                }
            }
            if (cArr[idx] == '-') {
                if(idx+2<=N) {
                    res -= (cArr[idx + 1] - '0');
                    solve(idx + 2);
                    res += (cArr[idx + 1] - '0');
                }
                if (idx + 4 <= N) {
                    res -= cal(idx + 1, idx + 2, idx + 3);
                    solve(idx + 4);
                    res += cal(idx + 1, idx + 2, idx + 3);
                }
            }
            if (cArr[idx] == '*') {
                if(idx+2<=N) {
                    int temp = res;
                    res *= (cArr[idx + 1] - '0');
                    solve(idx + 2);
                    if((cArr[idx + 1] - '0')==0){
                        res=temp;
                    }else {
                        res /= (cArr[idx + 1] - '0');
                    }
                }
                if (idx + 4 <= N) {
                    int temp = res;
                    res *= cal(idx + 1, idx + 2, idx + 3);
                    solve(idx + 4);
                    if((cArr[idx + 1] - '0')==0 || cal(idx + 1, idx + 2, idx + 3)==0 ){
                        res=temp;
                    }else {
                        res /= cal(idx + 1, idx + 2, idx + 3);
                    }
                }
            }
        }
    }

    static int cal(int idx1, int idx2, int idx3) {
        if (cArr[idx2] == '+') {
            return (cArr[idx1]-'0') + (cArr[idx3]-'0');
        }
        if (cArr[idx2] == '-') {
            return (cArr[idx1]-'0') - (cArr[idx3]-'0');
        }
        if (cArr[idx2] == '*') {
            return (cArr[idx1]-'0') * (cArr[idx3]-'0');
        }
        return 0;
    }
    //괄호를 안치면 지금 값이랑 연산자 그다음 숫자랑 연산해서 res 변경 후 idx+2
    //괄호 치면  1.다음 숫자 다음 연산자 다다음 숫자랑 연산 후 idx+3
    //근데 괄호 사이 - 나오는거 조심해야하고
    //3+3+3
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='A'){
                if(i==s.length()-1) {
                    answer=0;
                    break;
                }
                else{
                    i++;
                    if(s.charAt(i)=='P') {
                        answer--;
                        if(answer<1) break;
                    }
                    else{
                        answer=0;
                        break;
                    }
                }
            }
            else answer++;
        }
        if(answer==1) System.out.println("PPAP");
        else System.out.println("NP");
    }
}

/*
String 입력 받기
    str<4
        str==p -> solve
        str!=p -> stop
    else
        0~3 PPAP 가능한지 확인
            되면 P로 변환
            안되면
                str<5 -> stop
                else
                    1~4 PPAP 가능한지 확인
                    되면 P로 전환
                    안되면 STOP

                    p
                    ppap
                    ppappap
                        pppapappap
                        p/p/appap
                        p/pap
                        p
                    pppapap
                    ppappap


                    ppap
                    ppappap
                    pppapap
                    ppappap
 */
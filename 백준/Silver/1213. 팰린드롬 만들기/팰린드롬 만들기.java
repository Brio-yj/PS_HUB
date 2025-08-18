
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] arr = new int[26];

        for (int i = 0; i < line.length(); i++) {arr[line.charAt(i) - 65]++;}
        //알파벳 갯수 확인

        int chkOdd = 0;
        for (int i = 0; i < 26; i++) {if (arr[i] % 2 != 0) {chkOdd++;}}
        //홀수 갯수 확인

        solve(chkOdd,arr,line.length());
    }

    public static void solve(int chkOdd, int[] arr, int size) {
        if (size % 2 == 0) {    //입력 짝수일때
            if (chkOdd >= 1) {System.out.println("I'm Sorry Hansoo");}  //입력짝수,홀수 1개이상
            else {
                String s = new String();
                char alpha = ' ';

                for (int i = 0; i < arr.length; i++) {arr[i]/=2;}   // 알파벳 갯수 절반으로 줄이기
                for (int i = 0; i < arr.length; i++) {

                    if(arr[i]!=0) {
                        for(int j=0;j<arr[i];j++){
                        alpha = (char) ('A' + i);
                        s += alpha;
                        }
                    }
                }
                //문자열 앞판 완성
                String answer = new String();
                for (int i = s.length() - 1; i >= 0; i--) {answer += s.charAt(i);}   // 문자열 뒷판 완성
                s += answer;
                System.out.println(s);
                return;
            }
        }
        else {
            if (chkOdd >= 2) {
                System.out.println("I'm Sorry Hansoo");
            }
            else {
                char mid = ' ';
                for (int i = 0; i < arr.length; i++) {if (arr[i] % 2 != 0) mid = (char) ('A' + i);}
                //가운데 끼울 문자 찾기
                for (int i = 0; i < arr.length; i++) {arr[i]/=2;}
                // 알파벳 갯수 절반으로 줄이기

                String s = new String();
                char alpha = ' ';
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i]!=0) {
                        for(int j=0;j<arr[i];j++){
                        alpha = (char) ('A' + i);
                        s += alpha;
                        }
                    }
                }
                //앞판 완성
                String answer = new String();
                for (int i = s.length() - 1; i >= 0; i--) {
                    answer += s.charAt(i);
                }
                //뒷판 완성
                s = s + mid + answer;
                System.out.println(s);
                return;
            }
        }
    }
}


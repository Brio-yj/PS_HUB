import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt =0;
        for(int i=0;i<n;i++){
            String s = br.readLine();

            if(solve(s))cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean solve(String s){
        boolean[] arr = new boolean[26];
        boolean con = true;
        for(int i=0;i<s.length();i++){
            if(i>=1 && s.charAt(i-1)!=s.charAt(i)) con = false;
            if(i>=1 && s.charAt(i-1)==s.charAt(i)) con = true;
            if(arr[s.charAt(i)-'a'] && !con) return false;
            if(!arr[s.charAt(i)-'a']) arr[s.charAt(i)-'a']=true;
        }
        return true;
    }
}

/*
들어오면 체크
넘어갔는데 또 들어오면 리턴
 */
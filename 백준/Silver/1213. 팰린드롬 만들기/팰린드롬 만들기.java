
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'A']++;
        }
        solve(arr);
    }
    static void solve(int[] arr){
        int twoMoreOdd = 0;
        char center=' ';
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0) twoMoreOdd++;
        }
        if(twoMoreOdd>=2){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1) {
                center=(char)('A'+i);
                continue;
            }
            if(arr[i]%2!=0) {
                center=(char)('A'+i);
            }
            for(int j=0;j<arr[i]/2;j++){
                char ch = (char)('A'+i);
                sb.append(ch);
            }
        }
        StringBuilder rsb = new StringBuilder(sb);
        rsb.reverse();
        if(center!=' ')sb.append((char)(center));
        sb.append(rsb);
        System.out.println(sb);
    }
}

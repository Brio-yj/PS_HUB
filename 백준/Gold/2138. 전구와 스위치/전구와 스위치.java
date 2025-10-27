
import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static char[] arr0,arr1,target;
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr0 = new char[n];
        arr1 = new char[n];
        target = new char[n];
        String s1 = br.readLine();
        String s2 = br.readLine();
        for(int i=0;i<n;i++){
            arr0[i]=s1.charAt(i);
            arr1[i]=s1.charAt(i);
            target[i]=s2.charAt(i);
        }
        button(0,arr0);
        int answer0=solve(arr0);
        int answer1=solve(arr1);
        if(answer0!=-1) answer0++;

        if(answer0!=-1 && answer1!=-1) System.out.println(Math.min(answer0,answer1));
        else System.out.println(Math.max(answer0,answer1));
    }
    static int solve(char[] arr){
        int cnt=0;
        for(int i=1;i<n;i++){
            if(arr[i-1]!=target[i-1]){
                button(i,arr);
                cnt++;
            }
        }
        boolean same = true;
        for(int i=0;i<n;i++){if(arr[i]!=target[i]) same = false;}
        if(!same) return -1;
        else return cnt;
    }
    static void button(int idx,char[] arr){
        if(arr[idx]=='0')arr[idx]='1';
        else if(arr[idx]=='1')arr[idx]='0';

        if(idx-1>=0 && arr[idx-1]=='0') arr[idx-1]='1';
        else if(idx-1>=0 && arr[idx-1]=='1') arr[idx-1]='0';

        if(idx+1<n && arr[idx+1]=='0') arr[idx+1]='1';
        else if(idx+1<n && arr[idx+1]=='1') arr[idx+1]='0';
    }
}

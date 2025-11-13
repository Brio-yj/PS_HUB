
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] arr1 =new int [52];
        for(int i=0;i<N;i++){
            if(s1.charAt(i)>='A' && s1.charAt(i)<='Z'){
                arr1[s1.charAt(i)-'A']++;
            }
            else{
                arr1[s1.charAt(i)-'a'+26]++;
            }
        }

        int[] arr2 =new int [52];
        for(int i=0;i<=N-2;i++){
            if(s2.charAt(i)>='A' && s2.charAt(i)<='Z'){
                arr2[s2.charAt(i)-'A']++;
            }
            else{
                arr2[s2.charAt(i)-'a'+26]++;
            }
        }

        int cnt=0;
        for(int i=0;i+N-1<M;i++){
            int left  = i;
            int right = i+N-1;

            if(s2.charAt(right)>='A' &&s2.charAt(right)<='Z'){
                arr2[s2.charAt(right)-'A']++;
            }
            else{
                arr2[s2.charAt(right)-'a'+26]++;
            }

            boolean same = true;
            for(int j=0;j<52;j++){
                if(arr1[j]!=arr2[j]){
                    same=false;
                }
            }
            if(same) cnt++;

            if(s2.charAt(left)>='A' &&s2.charAt(left)<='Z'){
                arr2[s2.charAt(left)-'A']--;
            }
            else{
                arr2[s2.charAt(left)-'a'+26]--;
            }
        }
        System.out.println(cnt);
    }
}

/*

s2에서 s1크기만큼 움직이면서 s1 구성 문자열 알파벳 갯수랑 동일한지 확인

한번에 가능할까?

처음에 s2도 초기화
    한칸씩 움직일때마다 제일처음거 삭제하고
    다음거 추가
        left 삭제
        right 추가
        즉, right 추가->비교->left삭제
            처음 셋팅할때 right 추가 할 수 있게 초기화 (0~N-2)
 */
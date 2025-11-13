

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            String s = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int[] cnt = new int[26];
            List<Integer>[] idxList = new ArrayList[26];
            for(int i=0;i<26;i++) idxList[i]=new ArrayList();

            for(int i=0;i<s.length();i++){
                cnt[s.charAt(i)-'a']++;
                idxList[s.charAt(i)-'a'].add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i=0;i<26;i++){
                List<Integer> list = idxList[i];
                if(list.size()<K) continue;

                for(int j=0;j+K-1<list.size();j++){
                    int left  = list.get(j);
                    int right = list.get(j+K-1);
                    int len = right-left+1;

                    min = Math.min(len,min);
                    max = Math.max(len,max);
                }
            }
            if(min==Integer.MAX_VALUE || max == Integer.MIN_VALUE)  sb.append(-1).append("\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}
/*
k개 이상인 것들만 한해서 확인
    문자열의 각 문자마다 cnt[]++, list.add(idx)
        k개 이상인 것만 확인
        left = 첫번째
        right = 첫번째 + k 번째
        그걸 한칸씩 통째로 움직이면서 확인 => sliding window
        right-left = size
        결국 사이즈 비교하면서 min, max 갱신
            둘중 하나라도 없을때 -1
*/
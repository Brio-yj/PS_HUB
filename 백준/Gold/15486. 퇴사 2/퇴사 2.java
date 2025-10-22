

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n+2];
        int[] P = new int[n+2];
        int[] dp = new int[n+2];

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=n;i>=1;i--){
            dp[i] = dp[i+1];

            if(i+T[i]<=n+1) dp[i] = Math.max(dp[i],dp[i+T[i]]+P[i]);
        }
        System.out.println(dp[1]);
    }
}

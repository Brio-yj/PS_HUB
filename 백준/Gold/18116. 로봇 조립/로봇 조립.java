
import java.io.*;
import java.util.*;
public class Main {
    static int[] parent,rank,cnt;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 1000001;
        cnt=new int[max];
        rank=new int[max];
        parent=new int[max];
        for(int i=0;i<=max-1;i++)parent[i]=i;
        for(int i=0;i<=max-1;i++)cnt[i]=1;

        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            if(ch=='I'){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                uni(a,b);
            }
            else{System.out.println(cnt[find(Integer.parseInt(st.nextToken()))]);}
        }
    }
    static int find(int num){
        if(parent[num]==num) return num;
        return parent[num]=find(parent[num]);
    }
    static void uni(int a,int b){
        a=find(a);
        b=find(b);

        if(a==b) return;

        if(rank[a]<rank[b]) {
            cnt[b]+=cnt[a];
            parent[a]=b;
        }
        else if(rank[a]>rank[b]) {
            cnt[a]+=cnt[b];
            parent[b]=a;
        }
        else{
            rank[a]++;
            cnt[a]+=cnt[b];
            parent[b]=a;
        }
    }
}


import java.io.*;
import java.util.*;
public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=0;i<=N;i++) parent[i]=i;

        st = new StringTokenizer(br.readLine());
        int trueCnt = Integer.parseInt(st.nextToken());
        int[] truePeople = new int[trueCnt];

        if(trueCnt>0){
            int tempRoot = Integer.parseInt(st.nextToken());
            truePeople[0]=tempRoot;
            for(int i=1;i<trueCnt;i++){
                truePeople[i]=Integer.parseInt(st.nextToken());
                uni(truePeople[0],truePeople[i]);
            }
        }

        List<Integer>[] list = new ArrayList[M];
        for(int i=0;i<M;i++){
            list[i] = new ArrayList();
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int root = Integer.parseInt(st.nextToken());
            list[i].add(root);
            for(int j=1;j<cnt;j++){
                int temp = Integer.parseInt(st.nextToken());
                list[i].add(temp);
                uni(root,temp);
            }
        }

        int answer=0;
        for(int i=0;i<M;i++){
            boolean canLie = true;
            if(trueCnt >0 && find(list[i].get(0)) == find(truePeople[0])) canLie = false;
            if(canLie) answer++;
        }
        System.out.println(answer);
    }

    static int find(int num){
        if(parent[num]==num) return num;
        return parent[num]=find(parent[num]);
    }
    static void uni(int u,int v){
        u = find(u);
        v = find(v);

        if(u==v) return;
        else{
            parent[v] = u;
        }
    }
}

import java.io.*;
import java.util.*;
public class Main {
    static int pos;
    static int[] parent,maxArr,minArr;
    static int[][] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        minArr = new int[N+1];
        maxArr = new int[N+1];
        tree = new int[2][N+1];

        Arrays.fill(minArr,Integer.MAX_VALUE);
        Arrays.fill(maxArr,Integer.MIN_VALUE);

        for(int i=0;i<N;i++){
            StringTokenizer st  = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[0][idx]=left;
            tree[1][idx]=right;

            if(left!=-1) parent[left]=idx;
            if(right!=-1) parent[right]=idx;
        }
        int root=-1;
        for(int i=1;i<=N;i++){
            if(parent[i]==0) root=i;
        }

        inOrder(root,1);

        int len = -1;
        int depth = -1;
        for(int i=1;i<=N;i++){
            int left = minArr[i];
            int right = maxArr[i];

            if(left!=Integer.MAX_VALUE && right!=Integer.MIN_VALUE && len<right-left+1) {
                len=right-left+1;
                depth=i;
            }
        }

        System.out.println(depth+" "+len);
    }
    static void inOrder(int node,int depth){
        if(node==-1) return;

        inOrder(tree[0][node],depth+1);
        pos++;
        minArr[depth]=Math.min(minArr[depth],pos);
        maxArr[depth]=Math.max(maxArr[depth],pos);
        inOrder(tree[1][node],depth+1);
    }
}
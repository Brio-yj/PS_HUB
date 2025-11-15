
import java.io.*;
import java.util.*;
public class Main {
    static char[] parent;
    static char[][] tree;
    static List<Character> preList = new ArrayList();
    static List<Character> inList = new ArrayList();
    static List<Character> postList = new ArrayList();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new char[N+1];
        tree = new char[2][N+1];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[0][root-'A']=left;
            tree[1][root-'A']=right;

            if(left!='.') parent[left-'A'] = root;
            if(right!='.') parent[right-'A'] = root;
        }

        preOrder('A');
        inOrder('A');
        postOrder('A');

        for(char ch:preList) System.out.print(ch);
        System.out.println();
        for(char ch:inList) System.out.print(ch);
        System.out.println();
        for(char ch:postList) System.out.print(ch);

    }
    static void preOrder(char node){
        if(node=='.') return;

        preList.add(node);
        preOrder(tree[0][node-'A']);
        preOrder(tree[1][node-'A']);
    }
    static void inOrder(char node){
        if(node=='.') return;

        inOrder(tree[0][node-'A']);
        inList.add(node);
        inOrder(tree[1][node-'A']);
    }
    static void postOrder(char node){
        if(node=='.') return;

        postOrder(tree[0][node-'A']);
        postOrder(tree[1][node-'A']);
        postList.add(node);
    }
}
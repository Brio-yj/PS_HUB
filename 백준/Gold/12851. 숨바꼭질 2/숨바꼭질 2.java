
import java.io.*;
import java.util.*;
public class Main {
    static class Person{
        int idx,cnt;
        Person(int idx,int cnt){
            this.idx=idx;
            this.cnt=cnt;
        }
    }
    static int N,K;
    static int target=Integer.MAX_VALUE;
    static boolean fFind = false;
    static int[] board = new int[1000001];
    static Map<Integer,Integer> map = new HashMap();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        bfs(new Person(N,0));
        List<Integer> nList = new ArrayList(map.keySet());
        nList.sort(null);
        System.out.println(nList.get(0));
        System.out.println(map.get(nList.get(0)));
    }
    static void bfs(Person p){
        Queue<Person> q = new LinkedList();
        q.add(p);
        while(!q.isEmpty()){
            Person cur = q.poll();
            board[cur.idx]=1;
            if(cur.idx==K){
                if(!fFind){
                    target=cur.cnt;
                    fFind=true;
                }
                map.put(cur.cnt,map.getOrDefault(cur.cnt,0)+1);
            }
            else{
                if(cur.idx-1>=0 && cur.idx-1<=1000000 && cur.cnt<target && board[cur.idx-1]==0){
                    q.add(new Person(cur.idx-1,cur.cnt+1));
                }
                if(cur.idx+1>=0 && cur.idx+1<=1000000 && cur.cnt<target&& board[cur.idx+1]==0){
                    q.add(new Person(cur.idx+1,cur.cnt+1));
                }
                if(cur.idx*2>=0 && cur.idx*2<=1000000 && cur.cnt<target&& board[cur.idx*2]==0){
                    q.add(new Person(cur.idx*2,cur.cnt+1));
                }
            }
        }
    }
}

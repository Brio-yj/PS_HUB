

import java.io.*;
import java.util.*;
public class Main {
    static List<Long> list = new ArrayList();
    static long answer = Long.MAX_VALUE;
    static long fi = 0;
    static long se = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            long num = Long.parseLong(st.nextToken());
            list.add(num);
        }
        boolean pass = false;
        for(int i=0;i<n;i++){
            if(solve(list.get(i))) {
                pass = true;
                break;
            }
        }
        if(!pass){
            System.out.println(fi+" "+se);
        }
    }
    static boolean solve(long target){
        int idx = Collections.binarySearch(list,target*-1);
        int idxCorr = idx*-1-1;

        if(idx>=0) {
            if(target==list.get(idx)) return false;
            System.out.println(target+" "+list.get(idx));
            return true;
        }

        else if(idx==-1){
            if(target==list.get(idxCorr)) idxCorr++;
            long temp = Math.abs(target+list.get(idxCorr));
            if(answer>temp){
                if(target<list.get(idxCorr)){fi = target; se = list.get(idxCorr); answer=temp;}
                else{fi = list.get(idxCorr); se = target; answer=temp;}
            }
        }

        else if(idx==list.size()*-1-1){
            idxCorr--;
            if(target==list.get(idxCorr)) idxCorr--;
            long temp = Math.abs(target+list.get(idxCorr));
            if(answer>temp){
                if(target<list.get(idxCorr)){fi = target; se = list.get(idxCorr); answer=temp;}
                else{fi = list.get(idxCorr); se = target; answer=temp;}
            }
        }

        else{
            long tempFi = Math.abs(target+list.get(idxCorr));
            long tempSe = Math.abs(target+list.get(idxCorr-1));
            if(target==list.get(idxCorr)) tempFi=Long.MAX_VALUE;
            if(target==list.get(idxCorr-1)) tempSe=Long.MAX_VALUE;
            if(tempFi<tempSe && tempFi<answer){
                if(target<list.get(idxCorr)){fi = target; se = list.get(idxCorr); answer=tempFi;}
                else{fi = list.get(idxCorr); se = target; answer=tempFi;}
            }
            else if(tempSe<tempFi && tempSe<answer){
                if(target<list.get(idxCorr-1)){fi = target; se = list.get(idxCorr-1); answer=tempSe;}
                else{fi = list.get(idxCorr-1); se = target; answer=tempSe;}
            }
        }

        return false;
    }
}
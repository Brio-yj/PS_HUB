import java.io.*;
import java.util.*;
class Solution {
    static List<Integer> list = new ArrayList();
    static Map<String,Integer> map = new HashMap();
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;
        for(int i=0;i<terms.length;i++){
            st = new StringTokenizer(terms[i]);
            String type = st.nextToken();
            int month = Integer.parseInt(st.nextToken());
            map.put(type,month);
        }
        for(int i=0;i<privacies.length;i++){
            st = new StringTokenizer(privacies[i]);
            String prDate = st.nextToken();
            String prType = st.nextToken();
            if(solve(today,plus(prDate,prType))) list.add(i+1);
        }
        return list;
    }
    static boolean solve(String today, String yesterday){   //treu -상했다
        StringTokenizer st = new StringTokenizer(today);
        int Tyear    = Integer.parseInt(st.nextToken("."));
        int Tmonth   = Integer.parseInt(st.nextToken("."));
        int Tday     = Integer.parseInt(st.nextToken("."));
        
        st = new StringTokenizer(yesterday);
        int Yyear    = Integer.parseInt(st.nextToken("."));
        int Ymonth   = Integer.parseInt(st.nextToken("."));
        int Yday     = Integer.parseInt(st.nextToken("."));
        
        if(Yyear>Tyear) return false;
        else if(Yyear==Tyear && Ymonth>Tmonth)return false;
        else if(Yyear==Tyear && Ymonth==Tmonth && Yday>Tday) return false;
        else return true;
    } 
    static String plus(String prDate, String prType){
        StringTokenizer st = new StringTokenizer(prDate);
        int year    = Integer.parseInt(st.nextToken("."));
        int month   = Integer.parseInt(st.nextToken("."));
        int day     = Integer.parseInt(st.nextToken("."));
            month += map.get(prType);
        if(month>12) {
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(year)).append(".").
            append(Integer.toString(month)).append(".").
                append(Integer.toString(day));
        return sb.toString();
    }
}
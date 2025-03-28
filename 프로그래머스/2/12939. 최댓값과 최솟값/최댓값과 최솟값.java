import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);        
        List<Integer> list = new ArrayList<>();
        
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0)).append(" ").append(list.get(list.size()-1));
        String answer = sb.toString();
        return answer;
    }
}
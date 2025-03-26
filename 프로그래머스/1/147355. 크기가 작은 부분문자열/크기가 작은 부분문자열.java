import java.util.*;
import java.io.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long number = Long.parseLong(p);
        int numberSize = p.length();
        
        for(int i = 0; i<t.length() - numberSize + 1; i++){
            String temp = t.substring(i, i+numberSize);
            if(Long.parseLong(temp)<=number){
                answer++;
            }
        }
        
        return answer;
    }
}
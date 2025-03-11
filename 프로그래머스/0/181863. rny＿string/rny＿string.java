import java.io.*;
import java.util.*;

class Solution {
    public String solution(String rny_string) {
        char[] arr = rny_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<arr.length; i++){
            char now = arr[i];
            if(now == 'm'){
                sb.append("rn");
            }else{
                sb.append(now);
            }
        }
        String answer = sb.toString();
        return answer;
    }
}
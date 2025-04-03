import java.util.*;
class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        
        for(char now : arr){
            sb.append(now);
        }
        sb.reverse();
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}
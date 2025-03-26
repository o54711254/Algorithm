import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<arr.length; i++){
            char now = arr[i];
            if(map.containsKey(now)){
                answer[i] = i-map.get(now);
            }else{
                answer[i] = -1;
            }
            map.put(now, i);
        }
        return answer;
    }
}
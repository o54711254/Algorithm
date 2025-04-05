import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        Map<Long, Long> map = new HashMap<>();
        
        long num = 0;
        long index = 0;
        while(true){
            num = index * index;
            if(num > n){
                break;
            }
            map.put(num, index);
            index++;
        }
        
        if(map.containsKey(n)){
            answer = (map.get(n)+1) * (map.get(n)+1);
        }else{
            answer = -1;
        }
        return answer;
    }
}
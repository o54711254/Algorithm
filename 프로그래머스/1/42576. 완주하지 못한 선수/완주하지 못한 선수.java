import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        Deque<String> deque = new LinkedList<>();
        for(int i = 0; i<participant.length; i++){
            deque.add(participant[i]);
        }
        
        for(int i = 0; i<completion.length; i++){
            if(deque.peek().equals(completion[i])){
                deque.removeFirst();
            } else{
                answer = deque.poll();
                return answer;
            }
        }
        answer = deque.poll();
        
        return answer;
    }
}
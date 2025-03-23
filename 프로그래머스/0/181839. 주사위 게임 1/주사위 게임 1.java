import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        if(a % 2 != 0 && b % 2 != 0){
            answer = a*a + b*b;
            return answer;
        }else if(a % 2 != 0 || b%2 != 0){
            answer = 2*(a+b);
            return answer;
        }else{
            answer = Math.abs(a-b);
            return answer;
        }
    }
}
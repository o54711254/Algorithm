class Solution {
    public int solution(int n) {
        int answer = 2;
        n = n-1;
        while(true){
            if(n%answer == 0){
                break;
            }
            answer++;
        }
        
        return answer;
        
    }
}
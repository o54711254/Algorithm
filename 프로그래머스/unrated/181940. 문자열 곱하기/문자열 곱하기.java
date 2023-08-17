class Solution {
    public String solution(String my_string, int k) {
        String answer = "";
        for(int i = 0; i<k; i++){
            answer += my_string.substring(0, my_string.length());
        }
        return answer;
    }
}
class Solution {
    public int solution(String num_str) {
        int answer = 0;
        char[] arr = num_str.toCharArray();
        for(char num : arr){
            answer += Integer.parseInt(String.valueOf(num));
        }
        return answer;
    }
}
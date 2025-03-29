class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        char[] arr = num.toCharArray();
        int[] answer = new int[num.length()];
        int idx = 0;
        for(int i = num.length() - 1; i>=0; i--){
            answer[idx++] = arr[i]-48;
        }
        
        
        return answer;
    }
}
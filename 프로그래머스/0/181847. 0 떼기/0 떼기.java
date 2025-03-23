class Solution {
    public String solution(String n_str) {
        String answer = "";
        while(n_str.startsWith("0")){
            n_str = n_str.replaceFirst("0", "");
        }
        return n_str;
    }
}
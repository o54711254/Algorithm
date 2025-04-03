class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        
        int pCnt = 0;
        int yCnt = 0;
        for(char now : arr){
            if(now=='p'){
                pCnt++;
            }else if(now=='y'){
                yCnt++;
            }
        }
        return pCnt == yCnt ? true : false;
    }
}
class Solution {
    public int[] solution(int[] arr, int n) {
        boolean flag = arr.length %2 == 0 ? true : false;
        
        if(flag){
            for(int i = 0; i<arr.length; i++){
                if(i%2 != 0){
                    arr[i] += n;
                }
            }
        }else{
            for(int i = 0; i<arr.length; i++){
                if(i%2 == 0){
                    arr[i] += n;
                }
            }
        }
        return arr;
    }
}
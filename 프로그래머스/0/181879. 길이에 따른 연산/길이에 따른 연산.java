class Solution {
    public int solution(int[] num_list) {
        int size = num_list.length;
        boolean flag = size >= 11 ? true : false;
        int result = flag ? 0 : 1;
        for(int i = 0; i<size; i++){
            if(size>=11){
                result += num_list[i];
            }else{
                result *= num_list[i];
            }
        }
        return result;
    }
}
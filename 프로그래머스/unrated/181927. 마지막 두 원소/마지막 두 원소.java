class Solution {
    public int[] solution(int[] num_list) {
          int[] arr = new int[num_list.length+1];
        
        for(int i = 0 ; i<num_list.length; i++) {
        	arr[i] = num_list[i];
        }
        if(num_list[num_list.length-1]>num_list[num_list.length-2]) {
        	arr[arr.length-1] = arr[arr.length-2]-arr[arr.length-3];
        }else {
        	arr[arr.length-1] = arr[arr.length-2]*2;
        }
        return arr;
    }
}
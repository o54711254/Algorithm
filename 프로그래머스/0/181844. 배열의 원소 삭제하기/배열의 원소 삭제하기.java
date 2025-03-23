import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        List<Integer> deleteList = new ArrayList<>();
        
        for(int num : delete_list){
            deleteList.add(num);
        }
        
        for(int num : arr){
            if(deleteList.contains(num)){
                continue;
            }
            list.add(num);    
        }
        
        return list;
    }
}
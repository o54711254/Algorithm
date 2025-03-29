import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if(arr.length -1 == 0){
            list.add(-1);
            return list;
        }

        int minIdx = 0;
        int minValue = Integer.MAX_VALUE;
        
        for(int i = 0; i<arr.length; i++){
            int num = arr[i];
            if(num<minValue){
                minIdx = i;
                minValue = num;
            }
            list.add(num);
        }
        list.remove(minIdx);
        
        return list;
    }
}
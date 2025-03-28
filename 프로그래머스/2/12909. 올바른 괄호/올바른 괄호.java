import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        if(arr.length % 2 != 0){
            return false;
        }
        
        Queue<Character> queue = new LinkedList<>();
        
        for(char now : arr){
            if(now == '('){
                queue.add(now);    
            }else{
                if(queue.isEmpty()){
                    return false;
                }else{
                    queue.poll();
                }
            }
        }
        
        if(queue.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        if(arr.length % 2 != 0){
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(char now : arr){
            if(now == '('){
                stack.push(now);    
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
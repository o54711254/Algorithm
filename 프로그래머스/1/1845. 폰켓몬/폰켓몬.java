import java.io.*;
import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(int[] nums) {
        int length = nums.length;
        for(int i = 0; i<length; i++){
            set.add(nums[i]);
        }
        
        int limit = length/2;
        
        int answer = limit>set.size() ? set.size() : limit;
        return answer;
    }
}
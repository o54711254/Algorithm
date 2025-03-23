import java.util.*;
import java.io.*;
class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        StringBuilder str = new StringBuilder(my_string);
        
        for(int i = 0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            StringBuilder sb = new StringBuilder(str.substring(start, end + 1));
            sb.reverse();
            str.replace(start, end+1, sb.toString());
        }
        return str.toString();
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int limit;
    static boolean flag = false;
    static String s, t;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        limit = t.length() - s.length();
        solution(t, 0);
        System.out.println(flag ? 1 : 0);
    }
    
    private static void solution(String text, int depth) {
        if (text.length() == s.length()) {
            if (text.equals(s)) {
                flag = true;
            }
            return;
        }
        
        if (text.charAt(text.length() - 1) == 'A') {
            solution(text.substring(0, text.length() - 1), depth + 1);
        }
        
        if (text.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(text);
            sb.reverse();
            solution(sb.substring(0, sb.length() - 1), depth + 1);
        }
    }
}
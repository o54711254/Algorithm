import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String start = br.readLine();
        String word = br.readLine();

        System.out.println(solve(start, word) ? 1 : 0);
    }
    
    public static boolean solve(String start, String word) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : word.toCharArray()) {
            deque.add(c);
        }
        
        boolean isForward = true;
        
        while (deque.size() > start.length()) {
            if (isForward) {
                // 마지막 문자가 'A'인 경우 제거
                if (deque.peekLast() == 'A') {
                    deque.removeLast();
                }
                // 마지막 문자가 'B'인 경우 뒤집기
                else if (deque.peekLast() == 'B') {
                    isForward = false;
                    deque.removeLast();
                }
                else {
                    return false;
                }
            } else {
                // 첫 문자가 'A'인 경우 제거
                if (deque.peekFirst() == 'A') {
                    deque.removeFirst();
                }
                // 첫 문자가 'B'인 경우 뒤집기
                else if (deque.peekFirst() == 'B') {
                    isForward = true;
                    deque.removeFirst();
                }
                else {
                    return false;
                }
            }
        }
        
        // 최종 문자열 비교
        StringBuilder sb = new StringBuilder();
        if (isForward) {
            while (!deque.isEmpty()) {
                sb.append(deque.removeFirst());
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.removeLast());
            }
        }
        
        return sb.toString().equals(start);
    }
}
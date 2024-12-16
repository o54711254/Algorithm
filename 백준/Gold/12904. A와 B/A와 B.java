import java.io.*;
import java.util.*;

/*
 * B
 * BA
 * ABB
 * ABBA
 * <==>
 * 1. 문자열 뒤에 A를 뺀다
 * 2. 문자열 뒤의 B를 빼고 뒤집는다.
 * LinkedList로 deque 구현 
 * 뒤집는건 boolean flag를 통해 구현  
 * 
 * 1. ABBA 
 * 2. ABB (removeLast)
 * 3. AB(= BA) (removeLast, false) 
 * 4. */

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String start = br.readLine();
		String word = br.readLine();

		char[] words = word.toCharArray();

		Deque<Character> deque = new LinkedList<Character>();

		for (int i = 0; i < words.length; i++) {
			deque.add(words[i]);
		}

		boolean flag = true;

		while (!deque.isEmpty() && deque.size() != start.length()) {
            if (flag) {
                if (deque.removeLast() == 'B') {
                    flag = false; // 뒤집기 상태로 전환
                }
            } else {
                if (deque.removeFirst() == 'B') {
                    flag = true; // 정방향 상태로 전환
                }
            }
        }

		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			if (flag) {
				sb.append(deque.removeFirst());
			} else {
				sb.append(deque.removeLast());
			}
		}

		if (sb.toString().equals(start)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
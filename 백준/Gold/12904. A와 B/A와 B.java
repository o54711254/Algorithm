import java.io.*;
import java.util.*;

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
					flag = !flag;
				}
			} else {
				if (deque.removeFirst() == 'B') {
					flag = !flag;
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

		System.out.println(sb.toString().equals(start) ? 1 : 0);
	}
}
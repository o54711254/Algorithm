import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		Deque<Integer> deque = new LinkedList<Integer>();
		sb = new StringBuilder();
		

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.contains("push")) {
				st = new StringTokenizer(input);
				String command = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				deque.add(number);
			} else {
				switch (input) {
				case "pop":
					if (deque.isEmpty()) {
						sb.append("-1");
					} else {
						sb.append(deque.poll());
					}
					break;
				case "size":
					sb.append(deque.size());
					break;
				case "empty":
					if (deque.isEmpty()) {
						sb.append("1");
					} else {
						sb.append(0);
					}
					break;
				case "top":
					if (deque.isEmpty()) {
						sb.append("-1");
					} else {
						sb.append(deque.peek());
					}
					break;
				case "front":
					if (deque.isEmpty()) {
						sb.append("-1");
					} else {
						sb.append(deque.getFirst());
					}
					break;
				case "back":
					if (deque.isEmpty()) {
						sb.append("-1");
					} else {
						sb.append(deque.getLast());
					}
					break;
				default:
					break;
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
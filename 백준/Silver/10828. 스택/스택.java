import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		Stack<Integer> stack = new Stack<Integer>();
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.contains("push")) {
				st = new StringTokenizer(input);
				String command = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				stack.add(number);
			} else {
				switch (input) {
				case "pop":
					if (stack.isEmpty()) {
						sb.append("-1");
					} else {
						sb.append(stack.pop());
					}
					break;
				case "size":
					sb.append(stack.size());
					break;
				case "empty":
					if (stack.isEmpty()) {
						sb.append("1");
					} else {
						sb.append(0);
					}
					break;
				case "top":
					if (stack.isEmpty()) {
						sb.append("-1");
					} else {
						sb.append(stack.peek());
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
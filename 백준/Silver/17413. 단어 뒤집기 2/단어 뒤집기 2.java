
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		String str = br.readLine();

		boolean check = false;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				check = true;
			} else if (str.charAt(i) == '>') {
				check = false;
				sb.append(str.charAt(i));
				continue;
			}
			if (str.charAt(i) == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
				continue;
				
			}
			if (check == true) {
				sb.append(str.charAt(i));
			} else if (check == false) {
				stack.push(str.charAt(i));
			}
			if(i==str.length()-1) {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
		}
		System.out.println(sb);
	}
}

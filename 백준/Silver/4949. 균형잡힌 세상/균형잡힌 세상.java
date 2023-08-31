
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		while (true) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			if (str.equals(".")) {
				break;
			}
			char[] arr = str.toCharArray();

			int count = 0;
			for (int i = 0; i < arr.length; i++) {

				if (arr[i] == '(' || arr[i] == '[') {
					stack.add(arr[i]);
				} else if (arr[i] == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						count++;
					}
				} else if (arr[i] == ']') {
					if (stack.isEmpty() || stack.pop() != '[') {
						count++;
					}
				}
			}

			for (int i = 0; i < stack.size(); i++) {
				count++;
			}
			if (count == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
		}

	}
}
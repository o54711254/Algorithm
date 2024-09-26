import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();
		String key = br.readLine();
		char[] arr = str.toCharArray();

		int keySize = key.length();

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < arr.length; i++) {
			stack.add(arr[i]);
			if (stack.size() >= keySize) {
				boolean flag = true;
				for (int j = 0; j < keySize; j++) {
					if (stack.get(stack.size() - keySize + j) != key.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < keySize; j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		if(sb.length() == 0 || sb == null) {
			System.out.println("FRULA");
		}
		System.out.println(sb);

	}
}
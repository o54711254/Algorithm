import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt();
			String s = sc.next();

			Stack<Character> build = new Stack<>();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				if (s.charAt(i) == '+') {
					build.push(s.charAt(i));
				} else {
					sb.append(s.charAt(i));
				}
			}

			while (!build.isEmpty()) {
				sb.append(build.pop());
			}

			Stack<Integer> result = new Stack<>();

			for (int i = 0; i < N; i++) {
				if(sb.charAt(i) != '+') {
					result.push(sb.charAt(i)-'0');
				}else {
					int num1 = result.pop();
					int num2 = result.pop();
					result.push(num2+num1);
				}
			}
			int res = result.pop();
			
			System.out.println("#"+tc+" "+res);
		}

	}
}

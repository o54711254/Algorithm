import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {

			Stack<Integer> check = new Stack<>();

			int N = sc.nextInt();

			String s = sc.next();

			char[] a = s.toCharArray();

			for (int i = 0; i < N; i++) {
				if (a[i] == '(') {
					check.push(1);
				} else if (a[i] == ')') {
					check.push(-1);
				}else if (a[i] == '{') {
					check.push(2);
				}else if (a[i] == '}') {
					check.push(-2);
				}else if (a[i] == '[') {
					check.push(3);
				}else if (a[i] == ']') {
					check.push(-3);
				}else if (a[i] == '<') {
					check.push(4);
				}else if (a[i] == '>') {
					check.push(-4);
				}
			}
			int sum = 0;
			for(int i = 0; i<check.size(); i++) {
				sum += check.get(i);
				}
			
			if(sum == 0) {
				System.out.println("#"+tc+" "+ 1);
			}else {
				System.out.println("#"+tc+" "+0);
			}

		}
	}
}

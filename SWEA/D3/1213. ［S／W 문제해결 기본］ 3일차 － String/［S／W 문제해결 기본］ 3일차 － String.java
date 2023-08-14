import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {

			int tc = sc.nextInt();
			String s = sc.next();
			String s2 = sc.next();

			System.out.println("#"+tc+" "+bruteForceFor(s, s2));

		}

	}

	public static int bruteForceFor(String p, String t) {
		int N = t.length(); // 본문의 길이
		int M = p.length(); // 패턴의 길이

		int count = 0;
		for (int i = 0; i < N - M + 1; i++) {
			boolean flag = true;
			for (int j = 0; j < M; j++) {
				if (p.charAt(j) != t.charAt(i + j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
			}
		}
		return count;
	}
}

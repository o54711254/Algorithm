import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String text = br.readLine();
			sb.append(palindrome(text, 0, text.length() - 1, 0)).append("\n");
		}

		System.out.println(sb);
	}

	private static int palindrome(String text, int left, int right, int count) {
		if (count == 2) {
			return count;
		}
		while (left < right) {
			if (text.charAt(left) != text.charAt(right)) {
				int case1 = palindrome(text, left + 1, right, count + 1);
				int case2 = palindrome(text, left, right - 1, count + 1);
				return Math.min(case1, case2);
			}
			left++;
			right--;
		}

		return count;
	}
}
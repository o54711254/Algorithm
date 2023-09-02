
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int count = 1;
			sb.append(isPalindriome(str, count)).append("\n");
		}
		System.out.println(sb);
	}

	public static String recursion(String s, int start, int end, int count) {
		if (start >= end) {
			return "1" + " "+ count;
		}
		if (s.charAt(start) != s.charAt(end)) {
			return "0" + " "+ count;
		}
		count++;
		return recursion(s, start + 1, end - 1, count);
	}

	public static String isPalindriome(String s, int count) {
		return recursion(s, 0, s.length() - 1, count);
	}
}
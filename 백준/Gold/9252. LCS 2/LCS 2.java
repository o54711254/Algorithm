import java.util.*;
import java.io.*;

public class Main {
	static Integer[][] dp;
	static char[] arr1, arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 두 문자열 입력받기
		arr1 = br.readLine().toCharArray();
		arr2 = br.readLine().toCharArray();

		int length1 = arr1.length;
		int length2 = arr2.length;

		// DP 테이블 초기화
		dp = new Integer[length1][length2];

		// LCS 길이 출력
		System.out.println(LCS(length1 - 1, length2 - 1));

		// LCS 문자열 출력
		System.out.println(findStr(length1 - 1, length2 - 1));
	}

	// LCS 길이 계산
	private static int LCS(int x, int y) {
		if (x < 0 || y < 0) {
			return 0;
		}

		if (dp[x][y] == null) {
			if (arr1[x] == arr2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			} else {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}

		return dp[x][y];
	}

	// LCS 문자열 복원
	private static String findStr(int x, int y) {
		StringBuilder sb = new StringBuilder();

		while (x >= 0 && y >= 0) {
			if (arr1[x] == arr2[y]) {
				sb.append(arr1[x]);
				x--;
				y--;
			} else if (x > 0 && (y == 0 || dp[x - 1][y] >= dp[x][y - 1])) {
				x--;
			} else {
				y--;
			}
		}

		return sb.reverse().toString();
	}
}
import java.util.*;
import java.io.*;

public class Main {
	static char[] str1, str2, str3;
	static Integer[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		str3 = br.readLine().toCharArray();

		int length1 = str1.length;
		int length2 = str2.length;
		int length3 = str3.length;

		dp = new Integer[length1][length2][length3];

		System.out.println(LCS(length1 - 1, length2 - 1, length3 - 1));
	}

	static int LCS(int x, int y, int z) {

		if (x < 0 || y < 0 || z < 0) {
			return 0;
		}

		if (dp[x][y][z] == null) {
			dp[x][y][z] = 0;

			if (str1[x] == str2[y] && str2[y] == str3[z]) {
				dp[x][y][z] = LCS(x - 1, y - 1, z - 1) + 1;
			} else {
				dp[x][y][z] = Math.max(dp[x][y][z], LCS(x - 1, y, z));
				dp[x][y][z] = Math.max(dp[x][y][z], LCS(x, y - 1, z));
				dp[x][y][z] = Math.max(dp[x][y][z], LCS(x, y, z - 1));
				dp[x][y][z] = Math.max(dp[x][y][z], LCS(x - 1, y - 1, z));
				dp[x][y][z] = Math.max(dp[x][y][z], LCS(x - 1, y, z - 1));
				dp[x][y][z] = Math.max(dp[x][y][z], LCS(x, y - 1, z - 1));

			}

		}

		return dp[x][y][z];
	}
}
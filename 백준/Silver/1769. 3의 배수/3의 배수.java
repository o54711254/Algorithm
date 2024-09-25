import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();
		
		int result = 0;
		int cnt = 0;

		while (true) {
			int temp = 0;
			if (str.length() > 1) {
				cnt++;
				str = Integer.toString(sum(str));
			} else {
				result = sum(str);
				break;
			}
		}

		System.out.println(cnt);
		if (result % 3 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static int sum(String str) {
		char[] nums = str.toCharArray();
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			temp += nums[i] - '0';
		}
		return temp;
	}
}
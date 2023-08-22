import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			String s = br.readLine();

			char[] arr = s.toCharArray();

			int count = 0;
			int result = 0;
			for (int i = 0; i < arr.length; i++) {
				count++;
				if (arr[i] == 'X') {
					count = 0;
				}
				result += count;
			}
			System.out.println(result);
		}

	}
}

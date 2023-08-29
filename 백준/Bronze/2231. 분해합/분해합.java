import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			int result = i;
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				result += Character.getNumericValue(str.charAt(j));
			}
			if (result == N) {
				sum += i;
				break;
			}
		}
		System.out.println(sum);
	}
}

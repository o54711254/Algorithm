
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		while (true) {
			if (N % 5 == 0) {
				System.out.println(N / 5 + cnt);
				break;
			} else if (N < 0) {
				System.out.println(-1);
				break;
			}
			N = N - 3;
			cnt++;
		}
	}
}
